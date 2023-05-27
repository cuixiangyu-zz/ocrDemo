package com.cxy.ocrDemo.dao.sys.sqlprovider;

import com.cxy.ocrDemo.model.sys.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class SysUserSqlProvider {
    public StringBuilder findUser(@Param("userName")String userName,
                                  @Param("sex") Integer sex,
                                  @Param("age")Integer age,
                                  @Param("beginDate")String beginDate,
                                  @Param("endDate")String endDate){
        StringBuilder sql=new StringBuilder();
        sql.append("select * from tb_sys_user where is_del='0'");
        sql.append(panduantiaojian(userName,sex,age,beginDate,endDate));
        return sql;
    }
    public StringBuilder countUserList(@Param("userName")String userName,
                                       @Param("sex") Integer sex,
                                       @Param("age")Integer age,
                                       @Param("beginDate")String beginDate,
                                       @Param("endDate")String endDate){
        StringBuilder sql=new StringBuilder();
        sql.append("select count(id) from tb_sys_user where is_del='0'");
        sql.append(panduantiaojian(userName,sex,age,beginDate,endDate));
        return sql;

    }
    public StringBuilder panduantiaojian(String userName,Integer sex,Integer age,String beginDate, String endDate ){
        StringBuilder sql = new StringBuilder();
        if(userName != null && userName != ""){
            sql.append(" AND user_name like '%"+userName +"%'");
        }
        if(sex != null){
            sql.append(" AND sex = '"+ sex +"'");
        }
        if(age != null){
            sql.append(" AND age = '"+ age +"'");
        }
        if(beginDate != null && beginDate != "" && endDate != null && endDate != ""){
            sql.append(" AND date_format(create_time,\"%Y-%m-%d\") BETWEEN  date_format('"+beginDate+"',\"%Y-%m-%d\") AND date_format('" +endDate+"',\"%Y-%m-%d\")");
        }

        return sql;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sys_user
     *
     * @mbg.generated
     */
    public String insertSelective(SysUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tb_sys_user");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }


        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        if (record.getIsDel() != null) {
            sql.VALUES("is_del", "#{isDel,jdbcType=VARCHAR}");
        }
        if (record.getSalt() != null) {
            sql.VALUES("SALT", "#{salt,jdbcType=VARCHAR}");
        }

        if (record.getState() != null) {
            sql.VALUES("state", "#{state,jdbcType=TINYINT}");
        }

        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }

        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }

        if (record.getAge() != null) {
            sql.VALUES("age", "#{age,jdbcType=INTEGER}");
        }

        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=INTEGER}");
        }

        if (record.getIpLimit() != null) {
            sql.VALUES("ip_limit", "#{ipLimit,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCreater() != null) {
            sql.VALUES("creater", "#{creater,jdbcType=INTEGER}");
        }

        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sys_user
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(SysUser record) {
        SQL sql = new SQL();
        sql.UPDATE("tb_sys_user");
        //sql.SET("role_name = #{roleName,jdbcType=VARCHAR}");
        if (record.getEmail() != null) {
            sql.SET("email=#{email,jdbcType=VARCHAR}");
        }


        if (record.getName() != null) {
            sql.SET("name=#{name,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.SET("password=#{password,jdbcType=VARCHAR}");
        }

        if (record.getSalt() != null) {
            sql.SET("SALT=#{salt,jdbcType=VARCHAR}");
        }

        if (record.getState() != null) {
            sql.SET("state=#{state,jdbcType=TINYINT}");
        }

        if (record.getTel() != null) {
            sql.SET("tel=#{tel,jdbcType=VARCHAR}");
        }

        if (record.getUserName() != null) {
            sql.SET("user_name=#{userName,jdbcType=VARCHAR}");
        }

        if (record.getAge() != null) {
            sql.SET("age=#{age,jdbcType=INTEGER}");
        }
        if (record.getIsDel() != null) {
            sql.SET("is_del=#{isDel,jdbcType=INTEGER}");
        }

        if (record.getSex() != null) {
            sql.SET("sex=#{sex,jdbcType=INTEGER}");
        }

        if (record.getIpLimit() != null) {
            sql.SET("ip_limit=#{ipLimit,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time=#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCreater() != null) {
            sql.SET("creater=#{creater,jdbcType=INTEGER}");
        }

        if (record.getRemark() != null) {
            sql.SET("remark=#{remark,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }
}
