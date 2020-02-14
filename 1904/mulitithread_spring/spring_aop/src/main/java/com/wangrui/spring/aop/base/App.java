package com.wangrui.spring.aop.base;

import com.wangrui.spring.aop.base.entity.A;
import com.wangrui.spring.aop.base.service.ReportService;
import com.wangrui.spring.aop.base.service.ValidateReview;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         ReportService rs = new ReportService();
         ValidateReview vr = new ValidateReview();
         
         if(vr.validate(2)) {
        	 A report = rs.service(2);
             System.out.println(report);
         }
         
    }
}
