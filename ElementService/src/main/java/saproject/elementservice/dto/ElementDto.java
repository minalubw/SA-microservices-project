package saproject.elementservice.dto;

import saproject.elementservice.domain.ElementType;

public class ElementDto {

    private String elementId;
    private ElementType type;
    private int price;

    public ElementDto(){}
    public ElementDto(String elementId, ElementType type, int price) {
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


    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
