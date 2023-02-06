package saproject.elementservice.dto;

import saproject.elementservice.domain.Type;

public class ElementDto {

    private String elementId;
    private Type type;
    private int price;

    public ElementDto(){}
    public ElementDto(String elementId, Type type, int price) {
        this.elementId = elementId;
        this.type = type;
        this.price = price;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
