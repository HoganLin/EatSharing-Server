package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class FollowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FollowExample() {
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

        public Criteria andFoidIsNull() {
            addCriterion("foid is null");
            return (Criteria) this;
        }

        public Criteria andFoidIsNotNull() {
            addCriterion("foid is not null");
            return (Criteria) this;
        }

        public Criteria andFoidEqualTo(Integer value) {
            addCriterion("foid =", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidNotEqualTo(Integer value) {
            addCriterion("foid <>", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidGreaterThan(Integer value) {
            addCriterion("foid >", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("foid >=", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidLessThan(Integer value) {
            addCriterion("foid <", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidLessThanOrEqualTo(Integer value) {
            addCriterion("foid <=", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidIn(List<Integer> values) {
            addCriterion("foid in", values, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidNotIn(List<Integer> values) {
            addCriterion("foid not in", values, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidBetween(Integer value1, Integer value2) {
            addCriterion("foid between", value1, value2, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidNotBetween(Integer value1, Integer value2) {
            addCriterion("foid not between", value1, value2, "foid");
            return (Criteria) this;
        }

        public Criteria andUidUserIsNull() {
            addCriterion("uid_user is null");
            return (Criteria) this;
        }

        public Criteria andUidUserIsNotNull() {
            addCriterion("uid_user is not null");
            return (Criteria) this;
        }

        public Criteria andUidUserEqualTo(String value) {
            addCriterion("uid_user =", value, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserNotEqualTo(String value) {
            addCriterion("uid_user <>", value, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserGreaterThan(String value) {
            addCriterion("uid_user >", value, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserGreaterThanOrEqualTo(String value) {
            addCriterion("uid_user >=", value, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserLessThan(String value) {
            addCriterion("uid_user <", value, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserLessThanOrEqualTo(String value) {
            addCriterion("uid_user <=", value, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserLike(String value) {
            addCriterion("uid_user like", value, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserNotLike(String value) {
            addCriterion("uid_user not like", value, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserIn(List<String> values) {
            addCriterion("uid_user in", values, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserNotIn(List<String> values) {
            addCriterion("uid_user not in", values, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserBetween(String value1, String value2) {
            addCriterion("uid_user between", value1, value2, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidUserNotBetween(String value1, String value2) {
            addCriterion("uid_user not between", value1, value2, "uidUser");
            return (Criteria) this;
        }

        public Criteria andUidEdIsNull() {
            addCriterion("uid_ed is null");
            return (Criteria) this;
        }

        public Criteria andUidEdIsNotNull() {
            addCriterion("uid_ed is not null");
            return (Criteria) this;
        }

        public Criteria andUidEdEqualTo(String value) {
            addCriterion("uid_ed =", value, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdNotEqualTo(String value) {
            addCriterion("uid_ed <>", value, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdGreaterThan(String value) {
            addCriterion("uid_ed >", value, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdGreaterThanOrEqualTo(String value) {
            addCriterion("uid_ed >=", value, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdLessThan(String value) {
            addCriterion("uid_ed <", value, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdLessThanOrEqualTo(String value) {
            addCriterion("uid_ed <=", value, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdLike(String value) {
            addCriterion("uid_ed like", value, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdNotLike(String value) {
            addCriterion("uid_ed not like", value, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdIn(List<String> values) {
            addCriterion("uid_ed in", values, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdNotIn(List<String> values) {
            addCriterion("uid_ed not in", values, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdBetween(String value1, String value2) {
            addCriterion("uid_ed between", value1, value2, "uidEd");
            return (Criteria) this;
        }

        public Criteria andUidEdNotBetween(String value1, String value2) {
            addCriterion("uid_ed not between", value1, value2, "uidEd");
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