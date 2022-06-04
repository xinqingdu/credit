package com.itxiaodu.credit.entity.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectPOExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionIsNull() {
            addCriterion("project_description is null");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionIsNotNull() {
            addCriterion("project_description is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionEqualTo(String value) {
            addCriterion("project_description =", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionNotEqualTo(String value) {
            addCriterion("project_description <>", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionGreaterThan(String value) {
            addCriterion("project_description >", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("project_description >=", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionLessThan(String value) {
            addCriterion("project_description <", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionLessThanOrEqualTo(String value) {
            addCriterion("project_description <=", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionLike(String value) {
            addCriterion("project_description like", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionNotLike(String value) {
            addCriterion("project_description not like", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionIn(List<String> values) {
            addCriterion("project_description in", values, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionNotIn(List<String> values) {
            addCriterion("project_description not in", values, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionBetween(String value1, String value2) {
            addCriterion("project_description between", value1, value2, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionNotBetween(String value1, String value2) {
            addCriterion("project_description not between", value1, value2, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Long value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Long value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Long value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Long value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Long value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Long> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Long> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Long value1, Long value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Long value1, Long value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNull() {
            addCriterion("project_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNotNull() {
            addCriterion("project_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusEqualTo(Integer value) {
            addCriterion("project_status =", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotEqualTo(Integer value) {
            addCriterion("project_status <>", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThan(Integer value) {
            addCriterion("project_status >", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_status >=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThan(Integer value) {
            addCriterion("project_status <", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThanOrEqualTo(Integer value) {
            addCriterion("project_status <=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIn(List<Integer> values) {
            addCriterion("project_status in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotIn(List<Integer> values) {
            addCriterion("project_status not in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusBetween(Integer value1, Integer value2) {
            addCriterion("project_status between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("project_status not between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andDeployDateIsNull() {
            addCriterion("deploy_date is null");
            return (Criteria) this;
        }

        public Criteria andDeployDateIsNotNull() {
            addCriterion("deploy_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeployDateEqualTo(Date value) {
            addCriterionForJDBCDate("deploy_date =", value, "deployDate");
            return (Criteria) this;
        }

        public Criteria andDeployDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("deploy_date <>", value, "deployDate");
            return (Criteria) this;
        }

        public Criteria andDeployDateGreaterThan(Date value) {
            addCriterionForJDBCDate("deploy_date >", value, "deployDate");
            return (Criteria) this;
        }

        public Criteria andDeployDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deploy_date >=", value, "deployDate");
            return (Criteria) this;
        }

        public Criteria andDeployDateLessThan(Date value) {
            addCriterionForJDBCDate("deploy_date <", value, "deployDate");
            return (Criteria) this;
        }

        public Criteria andDeployDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deploy_date <=", value, "deployDate");
            return (Criteria) this;
        }

        public Criteria andDeployDateIn(List<Date> values) {
            addCriterionForJDBCDate("deploy_date in", values, "deployDate");
            return (Criteria) this;
        }

        public Criteria andDeployDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("deploy_date not in", values, "deployDate");
            return (Criteria) this;
        }

        public Criteria andDeployDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deploy_date between", value1, value2, "deployDate");
            return (Criteria) this;
        }

        public Criteria andDeployDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deploy_date not between", value1, value2, "deployDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
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

        public Criteria andSupportIsNull() {
            addCriterion("support is null");
            return (Criteria) this;
        }

        public Criteria andSupportIsNotNull() {
            addCriterion("support is not null");
            return (Criteria) this;
        }

        public Criteria andSupportEqualTo(Integer value) {
            addCriterion("support =", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportNotEqualTo(Integer value) {
            addCriterion("support <>", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportGreaterThan(Integer value) {
            addCriterion("support >", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportGreaterThanOrEqualTo(Integer value) {
            addCriterion("support >=", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportLessThan(Integer value) {
            addCriterion("support <", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportLessThanOrEqualTo(Integer value) {
            addCriterion("support <=", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportIn(List<Integer> values) {
            addCriterion("support in", values, "support");
            return (Criteria) this;
        }

        public Criteria andSupportNotIn(List<Integer> values) {
            addCriterion("support not in", values, "support");
            return (Criteria) this;
        }

        public Criteria andSupportBetween(Integer value1, Integer value2) {
            addCriterion("support between", value1, value2, "support");
            return (Criteria) this;
        }

        public Criteria andSupportNotBetween(Integer value1, Integer value2) {
            addCriterion("support not between", value1, value2, "support");
            return (Criteria) this;
        }

        public Criteria andCompletionsIsNull() {
            addCriterion("completions is null");
            return (Criteria) this;
        }

        public Criteria andCompletionsIsNotNull() {
            addCriterion("completions is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionsEqualTo(Integer value) {
            addCriterion("completions =", value, "completions");
            return (Criteria) this;
        }

        public Criteria andCompletionsNotEqualTo(Integer value) {
            addCriterion("completions <>", value, "completions");
            return (Criteria) this;
        }

        public Criteria andCompletionsGreaterThan(Integer value) {
            addCriterion("completions >", value, "completions");
            return (Criteria) this;
        }

        public Criteria andCompletionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("completions >=", value, "completions");
            return (Criteria) this;
        }

        public Criteria andCompletionsLessThan(Integer value) {
            addCriterion("completions <", value, "completions");
            return (Criteria) this;
        }

        public Criteria andCompletionsLessThanOrEqualTo(Integer value) {
            addCriterion("completions <=", value, "completions");
            return (Criteria) this;
        }

        public Criteria andCompletionsIn(List<Integer> values) {
            addCriterion("completions in", values, "completions");
            return (Criteria) this;
        }

        public Criteria andCompletionsNotIn(List<Integer> values) {
            addCriterion("completions not in", values, "completions");
            return (Criteria) this;
        }

        public Criteria andCompletionsBetween(Integer value1, Integer value2) {
            addCriterion("completions between", value1, value2, "completions");
            return (Criteria) this;
        }

        public Criteria andCompletionsNotBetween(Integer value1, Integer value2) {
            addCriterion("completions not between", value1, value2, "completions");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andFollowerIsNull() {
            addCriterion("follower is null");
            return (Criteria) this;
        }

        public Criteria andFollowerIsNotNull() {
            addCriterion("follower is not null");
            return (Criteria) this;
        }

        public Criteria andFollowerEqualTo(Integer value) {
            addCriterion("follower =", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerNotEqualTo(Integer value) {
            addCriterion("follower <>", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerGreaterThan(Integer value) {
            addCriterion("follower >", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("follower >=", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerLessThan(Integer value) {
            addCriterion("follower <", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerLessThanOrEqualTo(Integer value) {
            addCriterion("follower <=", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerIn(List<Integer> values) {
            addCriterion("follower in", values, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerNotIn(List<Integer> values) {
            addCriterion("follower not in", values, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerBetween(Integer value1, Integer value2) {
            addCriterion("follower between", value1, value2, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerNotBetween(Integer value1, Integer value2) {
            addCriterion("follower not between", value1, value2, "follower");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathIsNull() {
            addCriterion("header_picture_path is null");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathIsNotNull() {
            addCriterion("header_picture_path is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathEqualTo(String value) {
            addCriterion("header_picture_path =", value, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathNotEqualTo(String value) {
            addCriterion("header_picture_path <>", value, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathGreaterThan(String value) {
            addCriterion("header_picture_path >", value, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathGreaterThanOrEqualTo(String value) {
            addCriterion("header_picture_path >=", value, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathLessThan(String value) {
            addCriterion("header_picture_path <", value, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathLessThanOrEqualTo(String value) {
            addCriterion("header_picture_path <=", value, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathLike(String value) {
            addCriterion("header_picture_path like", value, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathNotLike(String value) {
            addCriterion("header_picture_path not like", value, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathIn(List<String> values) {
            addCriterion("header_picture_path in", values, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathNotIn(List<String> values) {
            addCriterion("header_picture_path not in", values, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathBetween(String value1, String value2) {
            addCriterion("header_picture_path between", value1, value2, "headerPicturePath");
            return (Criteria) this;
        }

        public Criteria andHeaderPicturePathNotBetween(String value1, String value2) {
            addCriterion("header_picture_path not between", value1, value2, "headerPicturePath");
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