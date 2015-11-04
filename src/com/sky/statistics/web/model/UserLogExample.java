package com.sky.statistics.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 封装查询条件
 */
public class UserLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLogExample() {
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

        /**
         * 添加表关联（当）
         * @return
         */
        public Criteria relationUser() {
            addCriterion("usl.user_id = us.id");
            return (Criteria) this;
        }

        //重名字段要加表别名区分
        public Criteria andIdIsNull() {
            addCriterion("usl.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("usl.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("usl.id =", value, "d");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("usl.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("usl.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("usl.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("usl.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("usl.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("usl.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("usl.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("usl.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("usl.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIDIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIDIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIDEqualTo(Long value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDGreaterThan(Long value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDLessThan(Long value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDLike(Long value) {
            addCriterion("user_id like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDNotLike(Long value) {
            addCriterion("user_id not like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDIn(List<Long> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIDNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }


        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(int value) {
            addCriterion("log_type =", value, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(int value) {
            addCriterion("log_type <>", value, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(int value) {
            addCriterion("log_type >", value, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(int value) {
            addCriterion("log_type >=", value, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(int value) {
            addCriterion("log_type <", value, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(int value) {
            addCriterion("log_type <=", value, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(int value) {
            addCriterion("log_type like", value, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(int value) {
            addCriterion("log_type not like", value, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<Integer> values) {
            addCriterion("log_type in", values, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<Integer> values) {
            addCriterion("log_type not in", values, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(int value1, int value2) {
            addCriterion("log_type between", value1, value2, "log_type");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(int value1, int value2) {
            addCriterion("log_type not between", value1, value2, "log_type");
            return (Criteria) this;
        }

        //
        public Criteria andLogTimeIsNull() {
            addCriterion("Date(log_time) is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("Date(log_time) is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(String value) {
            addCriterion("Date(log_time) =", value, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("Date(log_time) <>", value, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("Date(log_time) >", value, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(String value) {
            addCriterion("Date(log_time) >=", value, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("Date(log_time) <", value, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("Date(log_time) <=", value, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeLike(Date value) {
            addCriterion("Date(log_time) like", value, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotLike(Date value) {
            addCriterion("Date(log_time) not like", value, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("Date(log_time) in", values, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("Date(log_time) not in", values, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("Date(log_time) between", value1, value2, "log_time");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("Date(log_time) not between", value1, value2, "log_time");
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