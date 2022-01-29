package com.pxf.counting.service;

import com.pxf.counting.dao.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface UserloginService {
   /**
    * 查询用信息
    * @param userInfo
    * @return
    */
   @Select("<script>"
           + " select id,nickname,id_car,sex,phone_number,crate_time,create_by,update_time,update_by "
           + " from user_info "
           + " where 1= 1 "
           + " and scbz= 0 "
           + "<if test='id != null and !\"\".equals(id)'> and id=#{id} </if>"
           + "<if test=' nickname != null and !\"\".equals(nickname)'> and nickname=#{nickname} </if>"
           + "<if test=' idCar != null and !\"\".equals(idCar)'> and id_car=#{idCar} </if>"
           + "<if test=' sex != null and !\"\".equals(sex)'> and sex=#{sex} </if>"
           + "<if test=' phoneNumber != null and !\"\".equals(phoneNumber)'> and phone_number=#{phoneNumber} </if>"
           + "</script>")
   public List<UserInfo> selectUserInfo(UserInfo userInfo);


   @Insert(" insert into user_info (id,nickname,id_car,sex,phone_number,create_by)"
           + " values  "
           + "(#{id},#{nickname},#{idCar},#{sex},#{phoneNumber},#{createBy})")
   public int insertUserInfo(UserInfo userInfo);

   @Update("<script> update user_info <trim prefix=\"set\" suffixOverrides=\",\">"
           + "<if test=' nickname != null and !\"\".equals(nickname)'>  nickname=#{nickname}, </if>"
           + "<if test=' idCar != null and !\"\".equals(idCar)'>  id_car=#{idCar}, </if>"
           + "<if test=' sex != null and !\"\".equals(sex)'>  sex=#{sex}, </if>"
           + "<if test=' phoneNumber != null and !\"\".equals(phoneNumber)'>  phone_number=#{phoneNumber} </if>"
           + "</trim> where id = #{id} "
           + "</script>")
   public int  udpdateUserInfo(UserInfo userInfo);

   @Update("<script> update user_info <trim prefix=\"set\" suffixOverrides=\",\">"
           + "scbz =1"
           + "</trim> where id = #{id} "
           + "</script>")
   public int  deleteUserInfo(UserInfo userInfo);
}
