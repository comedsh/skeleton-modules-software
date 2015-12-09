var bower = require('bower');
var concat = require('gulp-concat');
var gulp = require('gulp');
var gutil = require('gulp-util');
var minifyCss = require('gulp-minify-css');
var preprocess = require('gulp-preprocess');
var rename = require('gulp-rename');
var sass = require('gulp-sass');
var sh = require('shelljs');
var uglify = require('gulp-uglify');
var spritesmith = require('gulp.spritesmith');
var watch = require('gulp-watch');
var del = require('del');

//最终生产环境根路径
var ROOT_PATH="../src/main/webapp";
//最终生产环境js,css根路径
var RESOURCE_ROOT_PATH="../src/main/webapp/resources-old";

//清楚root目录下面bulid后的文件
gulp.task('clear', function() {
	return del(['../src/main/webapp/demo-old-html/**'
		, '../src/main/webapp/resources-old/**'], {force: true});
});


//打包发布sass文件
gulp.task('sass', function () {
	console.log('开始执行sass...');
  return gulp.src('scss/*.scss')
    .pipe(sass({outputStyle: 'expanded'}).on('error', sass.logError))
    //.pipe(minifyCss())//压缩css
    .pipe(gulp.dest(RESOURCE_ROOT_PATH+'/css/'));
});

//生成图片精灵
gulp.task('sprite', function () {
  var spriteData = gulp.src('img/icons/*.png').pipe(spritesmith({
  	//图片精灵存放的路径
    imgName: RESOURCE_ROOT_PATH+'/img/sprite.png',
    //css文件存放的路径
    cssName: RESOURCE_ROOT_PATH+'/css/sprite.css',
    //ico小图标在图片精灵中的排列方式
    algorithm:'left-right'
  }));
  //上面用到的路径依赖的根目录，为空则以gulpfile.js为准
  return spriteData.pipe(gulp.dest(''));
});

//合并找回密码所需js
gulp.task('FindPwdJS', function () {
	return gulp.src(['./js/common/header.js','./js/findpassword.js'])
	.pipe(concat('findpassword.js'))//合并后的文件名
    .pipe(gulp.dest(RESOURCE_ROOT_PATH+'/js'));
});

//合并登录页面所需js
// gulp.task('loginJS', function () {
// 	return gulp.src(['./js/common/header.js','./js/login.js'])
// 	.pipe(concat('login.js'))//合并后的文件名
//     .pipe(gulp.dest(RESOURCE_ROOT_PATH+'/js'));
// });

//合并js库(jquery, angular, underscore)
gulp.task('libJS', function () {
	return gulp.src(['./js/lib/angular/angular.min.js'
		, './js/lib/jquery/jquery.min.js'
		, './js/lib/underscore/underscore.min.js'])
	.pipe(concat('fenghua.lib.min.js'))
    .pipe(gulp.dest(RESOURCE_ROOT_PATH+'/js/lib/'));
});

//压缩合并common js文件
gulp.task('commonJS', function() {
	return gulp.src('./js/common/*.js')
    .pipe(uglify())
    .pipe(rename({extname: '.min.js' }))
    .pipe(gulp.dest(RESOURCE_ROOT_PATH+'/js/common/'))
    .pipe(concat('common.js'))
    .pipe(gulp.dest(RESOURCE_ROOT_PATH+'/js/common/'))
    .pipe(rename({extname: '.min.js' }))
    .pipe(uglify())
    .pipe(gulp.dest(RESOURCE_ROOT_PATH+'/js/common/'));
});

//copy html file to target source
gulp.task('copyHTML', function() {
	return gulp.src('./html/**')
	.pipe(gulp.dest(ROOT_PATH+'/demo-old-html/'));
});

//copy img file to target source
gulp.task('copyIMG', function() {
	return gulp.src('./img/**')
	.pipe(gulp.dest(RESOURCE_ROOT_PATH+'/img/'));
});


//index/////////////////////////////////////////////////////////////////////////////////////

//打包发布login相关联的js文件
gulp.task('build:index:js', function() {
	return gulp.src('./js/index/**')
	.pipe(concat('index.js'))
	.pipe(gulp.dest(RESOURCE_ROOT_PATH+'/js/index/'))
	.pipe(rename({extname: '.min.js'}))
	.pipe(uglify())
	.pipe(gulp.dest(RESOURCE_ROOT_PATH+'/js/index/'));
});

gulp.task('start', function() {

	watch('./html/**', function() {
		gulp.run('copyHTML');
	});
	watch('./img/**', function() {
		gulp.run([
			'copyIMG',
			'sprite'
		]);
	})
	watch('./scss/**', function() {
		gulp.run('sass');
	});
	watch('./js/**', function() {
		gulp.run([
			'FindPwdJS', 
			'commonJS'
		]);
	});

	return gulp.run([
		'FindPwdJS', 
		'commonJS', 
		'copyHTML', 
		'copyIMG',
		'sass',
		'sprite'
	]);
});
