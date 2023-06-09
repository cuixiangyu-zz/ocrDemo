package com.cxy.ocrDemo.dao.sys.sqlprovider;

import com.cxy.ocrDemo.model.sys.UserRole;
import org.apache.ibatis.jdbc.SQL;

public class UserRoleSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_role
     *
     * @mbg.generated
     */
    public String insertSelective(UserRole record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tb_user_role");

        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=INTEGER}");
        }

        if (record.getRoleId() != null) {
            sql.VALUES("ROLE_ID", "#{roleId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            sql.VALUES("USER_ID", "#{userId,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_role
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(UserRole record) {
        SQL sql = new SQL();
        sql.UPDATE("tb_user_role");

        if (record.getRoleId() != null) {
            sql.SET("ROLE_ID = #{roleId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            sql.SET("USER_ID = #{userId,jdbcType=INTEGER}");
        }

        sql.WHERE("ID = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }
}
