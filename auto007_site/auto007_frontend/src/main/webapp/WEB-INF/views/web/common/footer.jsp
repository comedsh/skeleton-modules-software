<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
.footer-bottom {
    text-align: center;
}
.l-width {
    margin: 0px auto;
    width: 1190px;
}

.inline {
    display: inline-block;
    vertical-align: top;
}
ul, li {
    list-style: outside none none;
    margin: 0px;
}

.menu-bottom__item:first-child {
    border-left: medium none;
}
.menu-bottom__item {
    border-left: 1px solid #FFF;
    float: left;
}
.menu-bottom__caption {
    color: #FFF;
    font-size: 14px;
    text-decoration: none;
    padding: 0px 18px;
}
a {
    color: #004098;
    outline: medium none;
    cursor: pointer;
    text-decoration: none;
}
.copyright-china {
    color: #FFF;
    font-size: 14px;
    margin-top: 20px;
}
</style>

<div class="footer-bottom">
		<div class="l-width">
			<ul class="menu-bottom inline flc">

									<li class="menu-bottom__item">
				<a class="menu-bottom__caption" href="/about/company/">
					<spring:message code="index.aboutus"/>
				</a>
			</li>
								<li class="menu-bottom__item">
				<a class="menu-bottom__caption" href="/message/"><spring:message code="index.contactus"/></a>
			</li>
								<li class="menu-bottom__item">
				<a class="menu-bottom__caption" href="/merchants_settled.html"><spring:message code="index.checkin"/></a>
			</li>
								<li class="menu-bottom__item">
				<a class="menu-bottom__caption" href="/sitemap.html"><spring:message code="index.links"/></a>
			</li>
								<li class="menu-bottom__item">
				<a class="menu-bottom__caption" href="/marketing_alliance.html"><spring:message code="index.saleshome"/></a>
			</li>
								<li class="menu-bottom__item">
				<a class="menu-bottom__caption" href="/forum.html"><spring:message code="index.bbs"/></a>
			</li>
			
</ul>			<div class="copyright-china">
				<spring:message code="index.beian"/>
			</div>
		</div>
	</div>