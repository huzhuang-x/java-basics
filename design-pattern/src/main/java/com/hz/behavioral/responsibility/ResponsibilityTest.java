package com.hz.behavioral.responsibility;

/**
 * @author HuZhuang
 * @description:
 * @date 2020/9/7
 **/
public class ResponsibilityTest {
    public static void main(String[] args) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setName("小明");
        leaveRequest.setLeaveDays(4);

        AbstractLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("主管");
        AbstractLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("经理");
        AbstractLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("总监");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);

        directLeaderLeaveHandler.handlerRequest(leaveRequest);
    }
}
