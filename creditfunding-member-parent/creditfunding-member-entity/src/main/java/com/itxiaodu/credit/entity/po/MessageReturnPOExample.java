package com.itxiaodu.credit.entity.po;

import java.util.ArrayList;
import java.util.List;

public class MessageReturnPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageReturnPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIsNull() {
            addCriterion("return_type is null");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIsNotNull() {
            addCriterion("return_type is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTypeEqualTo(Integer value) {
            addCriterion("return_type =", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotEqualTo(Integer value) {
            addCriterion("return_type <>", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeGreaterThan(Integer value) {
            addCriterion("return_type >", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_type >=", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLessThan(Integer value) {
            addCriterion("return_type <", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLessThanOrEqualTo(Integer value) {
            addCriterion("return_type <=", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIn(List<Integer> values) {
            addCriterion("return_type in", values, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotIn(List<Integer> values) {
            addCriterion("return_type not in", values, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeBetween(Integer value1, Integer value2) {
            addCriterion("return_type between", value1, value2, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("return_type not between", value1, value2, "returnType");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyIsNull() {
            addCriterion("support_money is null");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyIsNotNull() {
            addCriterion("support_money is not null");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyEqualTo(Long value) {
            addCriterion("support_money =", value, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyNotEqualTo(Long value) {
            addCriterion("support_money <>", value, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyGreaterThan(Long value) {
            addCriterion("support_money >", value, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("support_money >=", value, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyLessThan(Long value) {
            addCriterion("support_money <", value, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyLessThanOrEqualTo(Long value) {
            addCriterion("support_money <=", value, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyIn(List<Long> values) {
            addCriterion("support_money in", values, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyNotIn(List<Long> values) {
            addCriterion("support_money not in", values, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyBetween(Long value1, Long value2) {
            addCriterion("support_money between", value1, value2, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andSupportMoneyNotBetween(Long value1, Long value2) {
            addCriterion("support_money not between", value1, value2, "supportMoney");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseIsNull() {
            addCriterion("limit_purchase is null");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseIsNotNull() {
            addCriterion("limit_purchase is not null");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseEqualTo(Integer value) {
            addCriterion("limit_purchase =", value, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseNotEqualTo(Integer value) {
            addCriterion("limit_purchase <>", value, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseGreaterThan(Integer value) {
            addCriterion("limit_purchase >", value, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_purchase >=", value, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseLessThan(Integer value) {
            addCriterion("limit_purchase <", value, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseLessThanOrEqualTo(Integer value) {
            addCriterion("limit_purchase <=", value, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseIn(List<Integer> values) {
            addCriterion("limit_purchase in", values, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseNotIn(List<Integer> values) {
            addCriterion("limit_purchase not in", values, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseBetween(Integer value1, Integer value2) {
            addCriterion("limit_purchase between", value1, value2, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andLimitPurchaseNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_purchase not between", value1, value2, "limitPurchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseIsNull() {
            addCriterion("purchase is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseIsNotNull() {
            addCriterion("purchase is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseEqualTo(Integer value) {
            addCriterion("purchase =", value, "purchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseNotEqualTo(Integer value) {
            addCriterion("purchase <>", value, "purchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseGreaterThan(Integer value) {
            addCriterion("purchase >", value, "purchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase >=", value, "purchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseLessThan(Integer value) {
            addCriterion("purchase <", value, "purchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseLessThanOrEqualTo(Integer value) {
            addCriterion("purchase <=", value, "purchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseIn(List<Integer> values) {
            addCriterion("purchase in", values, "purchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseNotIn(List<Integer> values) {
            addCriterion("purchase not in", values, "purchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseBetween(Integer value1, Integer value2) {
            addCriterion("purchase between", value1, value2, "purchase");
            return (Criteria) this;
        }

        public Criteria andPurchaseNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase not between", value1, value2, "purchase");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(Integer value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(Integer value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(Integer value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(Integer value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(Integer value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(Integer value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<Integer> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<Integer> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(Integer value1, Integer value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(Integer value1, Integer value2) {
            addCriterion("freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNull() {
            addCriterion("invoice is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNotNull() {
            addCriterion("invoice is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEqualTo(Integer value) {
            addCriterion("invoice =", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotEqualTo(Integer value) {
            addCriterion("invoice <>", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThan(Integer value) {
            addCriterion("invoice >", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice >=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThan(Integer value) {
            addCriterion("invoice <", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThanOrEqualTo(Integer value) {
            addCriterion("invoice <=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceIn(List<Integer> values) {
            addCriterion("invoice in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotIn(List<Integer> values) {
            addCriterion("invoice not in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceBetween(Integer value1, Integer value2) {
            addCriterion("invoice between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice not between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andReturnDaysIsNull() {
            addCriterion("return_days is null");
            return (Criteria) this;
        }

        public Criteria andReturnDaysIsNotNull() {
            addCriterion("return_days is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDaysEqualTo(Integer value) {
            addCriterion("return_days =", value, "returnDays");
            return (Criteria) this;
        }

        public Criteria andReturnDaysNotEqualTo(Integer value) {
            addCriterion("return_days <>", value, "returnDays");
            return (Criteria) this;
        }

        public Criteria andReturnDaysGreaterThan(Integer value) {
            addCriterion("return_days >", value, "returnDays");
            return (Criteria) this;
        }

        public Criteria andReturnDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_days >=", value, "returnDays");
            return (Criteria) this;
        }

        public Criteria andReturnDaysLessThan(Integer value) {
            addCriterion("return_days <", value, "returnDays");
            return (Criteria) this;
        }

        public Criteria andReturnDaysLessThanOrEqualTo(Integer value) {
            addCriterion("return_days <=", value, "returnDays");
            return (Criteria) this;
        }

        public Criteria andReturnDaysIn(List<Integer> values) {
            addCriterion("return_days in", values, "returnDays");
            return (Criteria) this;
        }

        public Criteria andReturnDaysNotIn(List<Integer> values) {
            addCriterion("return_days not in", values, "returnDays");
            return (Criteria) this;
        }

        public Criteria andReturnDaysBetween(Integer value1, Integer value2) {
            addCriterion("return_days between", value1, value2, "returnDays");
            return (Criteria) this;
        }

        public Criteria andReturnDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("return_days not between", value1, value2, "returnDays");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathIsNull() {
            addCriterion("describ_picture_path is null");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathIsNotNull() {
            addCriterion("describ_picture_path is not null");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathEqualTo(String value) {
            addCriterion("describ_picture_path =", value, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathNotEqualTo(String value) {
            addCriterion("describ_picture_path <>", value, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathGreaterThan(String value) {
            addCriterion("describ_picture_path >", value, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathGreaterThanOrEqualTo(String value) {
            addCriterion("describ_picture_path >=", value, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathLessThan(String value) {
            addCriterion("describ_picture_path <", value, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathLessThanOrEqualTo(String value) {
            addCriterion("describ_picture_path <=", value, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathLike(String value) {
            addCriterion("describ_picture_path like", value, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathNotLike(String value) {
            addCriterion("describ_picture_path not like", value, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathIn(List<String> values) {
            addCriterion("describ_picture_path in", values, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathNotIn(List<String> values) {
            addCriterion("describ_picture_path not in", values, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathBetween(String value1, String value2) {
            addCriterion("describ_picture_path between", value1, value2, "describPicturePath");
            return (Criteria) this;
        }

        public Criteria andDescribPicturePathNotBetween(String value1, String value2) {
            addCriterion("describ_picture_path not between", value1, value2, "describPicturePath");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}