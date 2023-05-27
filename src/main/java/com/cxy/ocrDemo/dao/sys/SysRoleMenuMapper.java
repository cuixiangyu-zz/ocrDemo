package com.cxy.ocrDemo.dao.sys;

import com.cxy.ocrDemo.dao.sys.sqlprovider.SysRoleMenuSqlProvider;
import com.cxy.ocrDemo.model.sys.SysRoleMenu;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysRoleMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sys_role_menu
     *
     * @mbg.generated
     */
    @Delete({
        "delete from tb_sys_role_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @CacheEvict
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sys_role_menu
     *
     * @mbg.generated
     */
    @Insert({
        "insert into tb_sys_role_menu (id, role_id, ",
        "menu_id)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{menuId,jdbcType=INTEGER})"
    })
    @CachePut
    int insert(SysRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sys_role_menu
     *
     * @mbg.generated
     */
    @InsertProvider(type= SysRoleMenuSqlProvider.class, method="insertSelective")
    @CachePut
    int insertSelective(SysRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sys_role_menu
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, role_id, menu_id",
        "from tb_sys_role_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.INTEGER)
    })
    @Cacheable
    SysRoleMenu selectByPrimaryKey(Integer id);

    @Select("select menu_id from tb_sys_role_menu where role_id=#{roleId} ")
    @Cacheable
    List<Integer> selectMenuIdList(Integer roleId);

    @Delete("delete from tb_sys_role_menu where role_id=#{roleId}")
    @CacheEvict
    void deleteMenuByRoleId(Integer roleId);

    @Insert("<script>"  +
            "INSERT INTO tb_sys_role_menu(role_id,menu_id) "
            + "VALUES <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">" +
            "(#{item.roleId},#{item.menuId})" +
            " </foreach>"
            + "</script>")
    @CachePut
    void insertRoleMenu(@Param(value = "list") List<SysRoleMenu> list);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sys_role_menu
     *
     * @mbg.generated
     */
    @UpdateProvider(type=SysRoleMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    @CachePut
    int updateByPrimaryKeySelective(SysRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sys_role_menu
     *
     * @mbg.generated
     */
    @Update({
        "update tb_sys_role_menu",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "menu_id = #{menuId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @CachePut
    int updateByPrimaryKey(SysRoleMenu record);
}
