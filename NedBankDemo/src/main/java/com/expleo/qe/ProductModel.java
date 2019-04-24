package com.expleo.qe;

public class ProductModel
{
    String processor, ram, hdd, operatingSystem,microsoftOffice,acrobatReader,totalCommander,quantity;


    public ProductModel(String processor, String ram, String hdd,String operatingSystem,String microsoftOffice,
                        String acrobatReader,String totalCommander,String quantity)
    {
        setProcessor(processor);
        setRam(ram);
        setHdd(hdd);
        setOparatingSystem(operatingSystem);
        setMicrosoftOffice(microsoftOffice);
        setAcrobatReader(acrobatReader);
        setTotalCommander(totalCommander);
        setQuantity(quantity);

    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getOparatingSystem() {
        return operatingSystem;
    }

    public void setOparatingSystem(String oparatingSystem) {
        this.operatingSystem = oparatingSystem;
    }

    public String getMicrosoftOffice() {
        return microsoftOffice;
    }

    public void setMicrosoftOffice(String microsoftOffice) {
        this.microsoftOffice = microsoftOffice;
    }

    public String getAcrobatReader() {
        return acrobatReader;
    }

    public void setAcrobatReader(String acrobatReader) {
        this.acrobatReader = acrobatReader;
    }

    public String getTotalCommander() {
        return totalCommander;
    }

    public void setTotalCommander(String totalCommander) {
        this.totalCommander = totalCommander;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
