package com.fenghua.auto.sku.domain;

import com.fenghua.auto.backend.domain.DomainObject;

public class VehicleOeSku implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String oeCode;

    private Long vehicleId;

    private String vehicleName;

    private String brand;

    private String engine;

    private String period;

    private String outputValue;

    private Long skuId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOeCode() {
        return oeCode;
    }

    public void setOeCode(String oeCode) {
        this.oeCode = oeCode == null ? null : oeCode.trim();
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName == null ? null : vehicleName.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(String outputValue) {
        this.outputValue = outputValue == null ? null : outputValue.trim();
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}