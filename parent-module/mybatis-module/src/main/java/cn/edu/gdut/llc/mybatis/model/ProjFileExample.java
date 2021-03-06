package cn.edu.gdut.llc.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class ProjFileExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public ProjFileExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
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

        public Criteria andProjFileIdIsNull() {
            addCriterion("proj_file_id is null");
            return (Criteria) this;
        }

        public Criteria andProjFileIdIsNotNull() {
            addCriterion("proj_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjFileIdEqualTo(Integer value) {
            addCriterion("proj_file_id =", value, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjFileIdNotEqualTo(Integer value) {
            addCriterion("proj_file_id <>", value, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjFileIdGreaterThan(Integer value) {
            addCriterion("proj_file_id >", value, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("proj_file_id >=", value, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjFileIdLessThan(Integer value) {
            addCriterion("proj_file_id <", value, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("proj_file_id <=", value, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjFileIdIn(List<Integer> values) {
            addCriterion("proj_file_id in", values, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjFileIdNotIn(List<Integer> values) {
            addCriterion("proj_file_id not in", values, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjFileIdBetween(Integer value1, Integer value2) {
            addCriterion("proj_file_id between", value1, value2, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("proj_file_id not between", value1, value2, "projFileId");
            return (Criteria) this;
        }

        public Criteria andProjidIsNull() {
            addCriterion("projId is null");
            return (Criteria) this;
        }

        public Criteria andProjidIsNotNull() {
            addCriterion("projId is not null");
            return (Criteria) this;
        }

        public Criteria andProjidEqualTo(Integer value) {
            addCriterion("projId =", value, "projid");
            return (Criteria) this;
        }

        public Criteria andProjidNotEqualTo(Integer value) {
            addCriterion("projId <>", value, "projid");
            return (Criteria) this;
        }

        public Criteria andProjidGreaterThan(Integer value) {
            addCriterion("projId >", value, "projid");
            return (Criteria) this;
        }

        public Criteria andProjidGreaterThanOrEqualTo(Integer value) {
            addCriterion("projId >=", value, "projid");
            return (Criteria) this;
        }

        public Criteria andProjidLessThan(Integer value) {
            addCriterion("projId <", value, "projid");
            return (Criteria) this;
        }

        public Criteria andProjidLessThanOrEqualTo(Integer value) {
            addCriterion("projId <=", value, "projid");
            return (Criteria) this;
        }

        public Criteria andProjidIn(List<Integer> values) {
            addCriterion("projId in", values, "projid");
            return (Criteria) this;
        }

        public Criteria andProjidNotIn(List<Integer> values) {
            addCriterion("projId not in", values, "projid");
            return (Criteria) this;
        }

        public Criteria andProjidBetween(Integer value1, Integer value2) {
            addCriterion("projId between", value1, value2, "projid");
            return (Criteria) this;
        }

        public Criteria andProjidNotBetween(Integer value1, Integer value2) {
            addCriterion("projId not between", value1, value2, "projid");
            return (Criteria) this;
        }

        public Criteria andFileidIsNull() {
            addCriterion("fileId is null");
            return (Criteria) this;
        }

        public Criteria andFileidIsNotNull() {
            addCriterion("fileId is not null");
            return (Criteria) this;
        }

        public Criteria andFileidEqualTo(Integer value) {
            addCriterion("fileId =", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotEqualTo(Integer value) {
            addCriterion("fileId <>", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThan(Integer value) {
            addCriterion("fileId >", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fileId >=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThan(Integer value) {
            addCriterion("fileId <", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThanOrEqualTo(Integer value) {
            addCriterion("fileId <=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidIn(List<Integer> values) {
            addCriterion("fileId in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotIn(List<Integer> values) {
            addCriterion("fileId not in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidBetween(Integer value1, Integer value2) {
            addCriterion("fileId between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotBetween(Integer value1, Integer value2) {
            addCriterion("fileId not between", value1, value2, "fileid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table proj_file
     *
     * @mbggenerated do_not_delete_during_merge Sat Apr 21 19:07:34 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table proj_file
     *
     * @mbggenerated Sat Apr 21 19:07:34 CST 2018
     */
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