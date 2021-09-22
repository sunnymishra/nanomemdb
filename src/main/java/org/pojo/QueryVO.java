package org.pojo;

public class QueryVO {
    private String name;
    private String key;
    private String value;

    private QueryVO(Builder builder) {
        this.name = builder.name;
        this.key = builder.key;
        this.value = builder.value;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "QueryVO{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public static class Builder{
        private String name;
        private String key;
        private String value;

        // Constructor taking 1 argument 'name'
        public Builder(String name){
            this.name=name;
        }
        public Builder key(String key) {
            this.key = key;
            return this;
        }
        public Builder value(String value) {
            this.value = value;
            return this;
        }
        public QueryVO build() {
            QueryVO queryVO =  new QueryVO(this);
//          validate(queryVO);
            return queryVO;
        }
    }
}
