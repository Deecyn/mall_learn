package deecyn.mall_learn_15.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 搜索中的商品属性信息
 */
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer productAttributeId;

    // 属性值
    @Field(type = FieldType.Keyword)
    private String value;

    // 属性参数：0->规格；1->参数
    private Integer type;

    // 属性名称
    @Field(type=FieldType.Keyword)
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(Integer productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
