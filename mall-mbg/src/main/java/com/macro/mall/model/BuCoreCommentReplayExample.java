package com.macro.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuCoreCommentReplayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuCoreCommentReplayExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Long value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Long value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Long value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Long value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Long> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Long> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Long value1, Long value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNull() {
            addCriterion("user_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNotNull() {
            addCriterion("user_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameEqualTo(String value) {
            addCriterion("user_nick_name =", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotEqualTo(String value) {
            addCriterion("user_nick_name <>", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThan(String value) {
            addCriterion("user_nick_name >", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nick_name >=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThan(String value) {
            addCriterion("user_nick_name <", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThanOrEqualTo(String value) {
            addCriterion("user_nick_name <=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLike(String value) {
            addCriterion("user_nick_name like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotLike(String value) {
            addCriterion("user_nick_name not like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIn(List<String> values) {
            addCriterion("user_nick_name in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotIn(List<String> values) {
            addCriterion("user_nick_name not in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameBetween(String value1, String value2) {
            addCriterion("user_nick_name between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotBetween(String value1, String value2) {
            addCriterion("user_nick_name not between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserIconIsNull() {
            addCriterion("user_icon is null");
            return (Criteria) this;
        }

        public Criteria andUserIconIsNotNull() {
            addCriterion("user_icon is not null");
            return (Criteria) this;
        }

        public Criteria andUserIconEqualTo(String value) {
            addCriterion("user_icon =", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotEqualTo(String value) {
            addCriterion("user_icon <>", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconGreaterThan(String value) {
            addCriterion("user_icon >", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconGreaterThanOrEqualTo(String value) {
            addCriterion("user_icon >=", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconLessThan(String value) {
            addCriterion("user_icon <", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconLessThanOrEqualTo(String value) {
            addCriterion("user_icon <=", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconLike(String value) {
            addCriterion("user_icon like", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotLike(String value) {
            addCriterion("user_icon not like", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconIn(List<String> values) {
            addCriterion("user_icon in", values, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotIn(List<String> values) {
            addCriterion("user_icon not in", values, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconBetween(String value1, String value2) {
            addCriterion("user_icon between", value1, value2, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotBetween(String value1, String value2) {
            addCriterion("user_icon not between", value1, value2, "userIcon");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("show_status is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("show_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(Integer value) {
            addCriterion("show_status =", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(Integer value) {
            addCriterion("show_status <>", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(Integer value) {
            addCriterion("show_status >", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_status >=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(Integer value) {
            addCriterion("show_status <", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(Integer value) {
            addCriterion("show_status <=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<Integer> values) {
            addCriterion("show_status in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<Integer> values) {
            addCriterion("show_status not in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(Integer value1, Integer value2) {
            addCriterion("show_status between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("show_status not between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andReplyOrderIsNull() {
            addCriterion("reply_order is null");
            return (Criteria) this;
        }

        public Criteria andReplyOrderIsNotNull() {
            addCriterion("reply_order is not null");
            return (Criteria) this;
        }

        public Criteria andReplyOrderEqualTo(Integer value) {
            addCriterion("reply_order =", value, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andReplyOrderNotEqualTo(Integer value) {
            addCriterion("reply_order <>", value, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andReplyOrderGreaterThan(Integer value) {
            addCriterion("reply_order >", value, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andReplyOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_order >=", value, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andReplyOrderLessThan(Integer value) {
            addCriterion("reply_order <", value, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andReplyOrderLessThanOrEqualTo(Integer value) {
            addCriterion("reply_order <=", value, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andReplyOrderIn(List<Integer> values) {
            addCriterion("reply_order in", values, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andReplyOrderNotIn(List<Integer> values) {
            addCriterion("reply_order not in", values, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andReplyOrderBetween(Integer value1, Integer value2) {
            addCriterion("reply_order between", value1, value2, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andReplyOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_order not between", value1, value2, "replyOrder");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNull() {
            addCriterion("is_top is null");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNotNull() {
            addCriterion("is_top is not null");
            return (Criteria) this;
        }

        public Criteria andIsTopEqualTo(Integer value) {
            addCriterion("is_top =", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotEqualTo(Integer value) {
            addCriterion("is_top <>", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThan(Integer value) {
            addCriterion("is_top >", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_top >=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThan(Integer value) {
            addCriterion("is_top <", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThanOrEqualTo(Integer value) {
            addCriterion("is_top <=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopIn(List<Integer> values) {
            addCriterion("is_top in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotIn(List<Integer> values) {
            addCriterion("is_top not in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopBetween(Integer value1, Integer value2) {
            addCriterion("is_top between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotBetween(Integer value1, Integer value2) {
            addCriterion("is_top not between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsGoodIsNull() {
            addCriterion("is_good is null");
            return (Criteria) this;
        }

        public Criteria andIsGoodIsNotNull() {
            addCriterion("is_good is not null");
            return (Criteria) this;
        }

        public Criteria andIsGoodEqualTo(Integer value) {
            addCriterion("is_good =", value, "isGood");
            return (Criteria) this;
        }

        public Criteria andIsGoodNotEqualTo(Integer value) {
            addCriterion("is_good <>", value, "isGood");
            return (Criteria) this;
        }

        public Criteria andIsGoodGreaterThan(Integer value) {
            addCriterion("is_good >", value, "isGood");
            return (Criteria) this;
        }

        public Criteria andIsGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_good >=", value, "isGood");
            return (Criteria) this;
        }

        public Criteria andIsGoodLessThan(Integer value) {
            addCriterion("is_good <", value, "isGood");
            return (Criteria) this;
        }

        public Criteria andIsGoodLessThanOrEqualTo(Integer value) {
            addCriterion("is_good <=", value, "isGood");
            return (Criteria) this;
        }

        public Criteria andIsGoodIn(List<Integer> values) {
            addCriterion("is_good in", values, "isGood");
            return (Criteria) this;
        }

        public Criteria andIsGoodNotIn(List<Integer> values) {
            addCriterion("is_good not in", values, "isGood");
            return (Criteria) this;
        }

        public Criteria andIsGoodBetween(Integer value1, Integer value2) {
            addCriterion("is_good between", value1, value2, "isGood");
            return (Criteria) this;
        }

        public Criteria andIsGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("is_good not between", value1, value2, "isGood");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("read_count is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("read_count is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(Integer value) {
            addCriterion("read_count =", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(Integer value) {
            addCriterion("read_count <>", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(Integer value) {
            addCriterion("read_count >", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_count >=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(Integer value) {
            addCriterion("read_count <", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(Integer value) {
            addCriterion("read_count <=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<Integer> values) {
            addCriterion("read_count in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<Integer> values) {
            addCriterion("read_count not in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(Integer value1, Integer value2) {
            addCriterion("read_count between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(Integer value1, Integer value2) {
            addCriterion("read_count not between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNull() {
            addCriterion("like_count is null");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNotNull() {
            addCriterion("like_count is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCountEqualTo(Integer value) {
            addCriterion("like_count =", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotEqualTo(Integer value) {
            addCriterion("like_count <>", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThan(Integer value) {
            addCriterion("like_count >", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_count >=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThan(Integer value) {
            addCriterion("like_count <", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("like_count <=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIn(List<Integer> values) {
            addCriterion("like_count in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotIn(List<Integer> values) {
            addCriterion("like_count not in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("like_count between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("like_count not between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountIsNull() {
            addCriterion("unlike_count is null");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountIsNotNull() {
            addCriterion("unlike_count is not null");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountEqualTo(Integer value) {
            addCriterion("unlike_count =", value, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountNotEqualTo(Integer value) {
            addCriterion("unlike_count <>", value, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountGreaterThan(Integer value) {
            addCriterion("unlike_count >", value, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("unlike_count >=", value, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountLessThan(Integer value) {
            addCriterion("unlike_count <", value, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("unlike_count <=", value, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountIn(List<Integer> values) {
            addCriterion("unlike_count in", values, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountNotIn(List<Integer> values) {
            addCriterion("unlike_count not in", values, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountBetween(Integer value1, Integer value2) {
            addCriterion("unlike_count between", value1, value2, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andUnlikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("unlike_count not between", value1, value2, "unlikeCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNull() {
            addCriterion("reply_count is null");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNotNull() {
            addCriterion("reply_count is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCountEqualTo(Integer value) {
            addCriterion("reply_count =", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotEqualTo(Integer value) {
            addCriterion("reply_count <>", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThan(Integer value) {
            addCriterion("reply_count >", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_count >=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThan(Integer value) {
            addCriterion("reply_count <", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("reply_count <=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountIn(List<Integer> values) {
            addCriterion("reply_count in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotIn(List<Integer> values) {
            addCriterion("reply_count not in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountBetween(Integer value1, Integer value2) {
            addCriterion("reply_count between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_count not between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andExtIsNull() {
            addCriterion("ext is null");
            return (Criteria) this;
        }

        public Criteria andExtIsNotNull() {
            addCriterion("ext is not null");
            return (Criteria) this;
        }

        public Criteria andExtEqualTo(String value) {
            addCriterion("ext =", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotEqualTo(String value) {
            addCriterion("ext <>", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThan(String value) {
            addCriterion("ext >", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThanOrEqualTo(String value) {
            addCriterion("ext >=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThan(String value) {
            addCriterion("ext <", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThanOrEqualTo(String value) {
            addCriterion("ext <=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLike(String value) {
            addCriterion("ext like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotLike(String value) {
            addCriterion("ext not like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtIn(List<String> values) {
            addCriterion("ext in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotIn(List<String> values) {
            addCriterion("ext not in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtBetween(String value1, String value2) {
            addCriterion("ext between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotBetween(String value1, String value2) {
            addCriterion("ext not between", value1, value2, "ext");
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