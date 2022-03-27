package com.atguigu.dao;

import com.atguigu.pojo.Member;

import java.util.Date;

public interface MemberDao {
    Member getMemberByTelephone(String telephone);

    void add(Member member);

    Integer findMemberCountBeforeDate(String lastDayOfMonth);

    Integer findTodayNewMember(String today);

    Integer findThisWeekAndThisMonthNewMember(String weekMonday);
}
