package com.dt.user.provider;

import com.dt.user.dto.HrEmployeeDto;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class HrArchivesEmployeeProvider {


    public String upHrArchives(Map<String, Object> hrMap) {
        return new SQL() {{
            UPDATE("`hr_archives_employee`");
            if (hrMap.get("mobilePhone") != null) {
                String mobilePhone = (String) hrMap.get("mobilePhone");
                SET("mobile_phone=" + Long.parseLong(mobilePhone));
            }
            Integer uid = (Integer) hrMap.get("uid");
            WHERE("u_id=" + uid);
        }}.toString();
    }

    public String findEmployee(HrEmployeeDto employeeDto) {
        SQL sql = new SQL();
        String Alias = "se";
        sql.SELECT("se.`s_id`,se.`number`,\n" +
                "  se.`employee_name`,se.`employee_name_pinyin`,\n" +
                "  se.`employee_name_eng`,se.`sex`,se.`id_card`,se.`mobile_phone`,\n" +
                "  se.`is_in_service`,se.`status_id`,u.`name`,ad.`dept_name`,hn.`nation`\n" +
                "FROM `hr_archives_employee` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`system_user_info` as u ON u.`uid`= se.`u_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_department` as ad ON ad.`dept_id`=se.`dept_id`");
        sql.LEFT_OUTER_JOIN("`basic_hr_nation` AS hn ON hn.`nation_id`=se.`nation_id`");
        //状态数据查询
        ProviderSqlStore.saveStatus(employeeDto.getSystemLogStatus(), Alias, sql);
        //员工编号
        if (employeeDto.getNumber() != null) {
            sql.WHERE(Alias + ".`number`=#{number}");
        }
        //员工姓名
        if (StringUtils.isNotBlank(employeeDto.getEmployeeName())) {
            sql.WHERE(Alias + ".`employee_name`=#{employeeName}");
        }
        //员工姓名拼音
        if (StringUtils.isNotBlank(employeeDto.getEmployeeNamePinyin())) {
            sql.WHERE(Alias + ".`employee_name_pinyin`=#{employeeNamePinyin}");
        }
        //员工英文名
        if (StringUtils.isNotBlank(employeeDto.getEmployeeNameEng())) {
            sql.WHERE(Alias + ".`employee_name_eng`=#{employeeNameEng}");
        }
        //性别
        if (employeeDto.getSex() != null) {
            sql.WHERE(Alias + ".`sex`=#{sex}");
        }
        //员工手机
        if (employeeDto.getMobilePhone() != null) {
            sql.WHERE(Alias + ".`mobile_phone`=#{mobilePhone}");
        }
        //员工身份证
        if (StringUtils.isNotBlank(employeeDto.getIdCard())) {
            sql.WHERE(Alias + ".`id_card`=#{idCard}");
        }
        //员工是否在职
        if (employeeDto.getInService() != null) {
            sql.WHERE(Alias + ".`is_in_service`=#{isInService}");
        }
        //用户名
        if (StringUtils.isNotBlank(employeeDto.getUserName())) {
            sql.WHERE("u.`name`=#{name}");
        }
        //部门名
        if (StringUtils.isNotBlank(employeeDto.getDeptName())) {
            sql.WHERE("ad.`dept_name`=#{deptName}");
        }
        //名族
        if (StringUtils.isNotBlank(employeeDto.getNation())) {
            sql.WHERE("hn.`nation`=#{nation}");
        }
        return sql.toString();

    }

}
