package com.ttsh.mc.utils;


import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @创建人 蒋庆文
 * @创建时间 2018/3/2 15:19
 * @功能描述 日期工具类  123123123
 */
public class DateUtil {

    // ==格式到年==
    /**
     * 日期格式，年份，例如：2004，2008
     */
    public static final String DATE_FORMAT_YYYY = "yyyy";
    /**
     * 获取当前时间
     */
    public static final Date DATE_CURRENT = new Date();

    public static final String DATE_CURRENTContent = new SimpleDateFormat("yyyy-MM-dd HH:mm:00").format(new Date());

    // ==格式到年月 ==
    /**
     * 日期格式，年份和月份，例如：200707，200808
     */
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";

    /**
     * 日期格式，年份和月份，例如：200707，2008-08
     */
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";


    // ==格式到年月日==
    /**
     * 日期格式，年月日，例如：050630，080808
     */
    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：06-12-25，08-08-08
     */
    public static final String DATE_FORMAT_YY_MM_DD = "yy-MM-dd";

    /**
     * 日期格式，年月日，例如：20050630，20080808
     */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08
     */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 日期格式，年月日，例如：2016.10.05
     */
    public static final String DATE_FORMAT_POINTYYYYMMDD = "yyyy.MM.dd";

    /**
     * 日期格式，年月日，例如：2016年10月05日
     */
    public static final String DATE_TIME_FORMAT_YYYY年MM月DD日 = "yyyy年MM月dd日";


    // ==格式到年月日 时分 ==

    /**
     * 日期格式，年月日时分，例如：200506301210，200808081210
     */
    public static final String DATE_FORMAT_YYYYMMDDHHmm = "yyyyMMddHHmm";

    /**
     * 日期格式，年月日时分，例如：20001230 12:00，20080808 20:08
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDD_HH_MI = "yyyyMMdd HH:mm";

    /**
     * 日期格式，年月日时分，例如：2000-12-30 12:00，2008-08-08 20:08
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";


    // ==格式到年月日 时分秒==
    /**
     * 日期格式，年月日时分秒，例如：20001230120000，20080808200808
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";

    /**
     * 日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开
     * 例如：2005-05-10 23：20：00，2008-08-08 20:08:08
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm:00";

    // ==格式到年月日 时分秒 毫秒==
    /**
     * 日期格式，年月日时分秒毫秒，例如：20001230120000123，20080808200808456
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";


    // ==特殊格式==
    /**
     * 日期格式，月日时分，例如：10-05 12:00
     */
    public static final String DATE_FORMAT_MMDDHHMI = "MM-dd HH:mm";


    /* ************工具方法***************   */


    /**
     * 获取当前时间的日期 格式yyyy-MM-dd HH-mm-ss
     *
     * @return
     */
    public static String getNowDate2Str() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        return dateFormat.format(new Date());
    }

    /**
     * 获取某日期的年份
     *
     * @param date
     * @return
     */
    public static Integer getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取某日期的月份
     *
     * @param date
     * @return
     */
    public static Integer getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }


    /**
     * 根据两个月份差获取中间全部月份
     * @param start "2018-01"
     * @param end "2018-11"
     * @author ：2018-11-13 张立勇
     * @return
     */
    public static String[] getAllMonths(String start, String end){
        String splitSign="-";
        String regex="\\d{4}"+splitSign+"(([0][1-9])|([1][012]))"; //判断YYYY-MM时间格式的正则表达式
        if(!start.matches(regex) || !end.matches(regex)) return new String[0];
        List<String> list=new ArrayList<String>();
        if(start.compareTo(end)>0){
            //start大于end日期时，互换
            String temp=start;
            start=end;
            end=temp;
        }
        String temp=start; //从最小月份开始
        while(temp.compareTo(start) >= 0 && temp.compareTo(end) <= 0){
            list.add(temp); //首先加上最小月份,接着计算下一个月份
            String[] arr=temp.split(splitSign);
            int year=Integer.valueOf(arr[0]);
            int month=Integer.valueOf(arr[1])+1;
            if(month>12){
                month=1;
                year++;
            }
            if(month<10){//补0操作
                temp=year+splitSign+"0"+month;
            }else{
                temp=year+splitSign+month;
            }
        }
        int size=list.size();
        String[] result=new String[size];
        for(int i=0;i<size;i++){
            result[i]=list.get(i) + "-01";
        }
        return result;
    }
    /**
     * 获取某日期的日数
     *
     * @param date
     * @return
     */
    public static Integer getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //获取日
        int day = cal.get(Calendar.DATE);
        return day;
    }

    //获取一个月天数
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    //获取当前时间 yyyy-MM-dd 格式
    public static String getCurrentDateStr() {
        return DateUtil.parseDateToStr(new Date(),"yyyy-MM-dd");
    }

    /**
     * 格式化Date时间
     *
     * @param time       Date类型时间
     * @param timeFromat String类型格式
     * @return 格式化后的字符串
     */
    public static String parseDateToStr(Date time, String timeFromat) {
        if (time == null)
            return "";
        DateFormat dateFormat = new SimpleDateFormat(timeFromat);
        return dateFormat.format(time);
    }

    /**
     * 格式化Timestamp时间
     *
     * @param timestamp  Timestamp类型时间
     * @param timeFromat
     * @return 格式化后的字符串
     */
    public static String parseTimestampToStr(Timestamp timestamp, String timeFromat) {
        SimpleDateFormat df = new SimpleDateFormat(timeFromat);
        return df.format(timestamp);
    }

    /**
     * 格式化Date时间
     *
     * @param time         Date类型时间
     * @param timeFromat   String类型格式
     * @param defaultValue 默认值为当前时间Date
     * @return 格式化后的字符串
     */
    public static String parseDateToStr(Date time, String timeFromat, final Date defaultValue) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(timeFromat);
            return dateFormat.format(time);
        } catch (Exception e) {
            if (defaultValue != null)
                return parseDateToStr(defaultValue, timeFromat);
            else
                return parseDateToStr(new Date(), timeFromat);
        }
    }

    /**
     * 格式化Date时间
     *
     * @param time         Date类型时间
     * @param timeFromat   String类型格式
     * @param defaultValue 默认时间值String类型
     * @return 格式化后的字符串
     */
    public static String parseDateToStr(Date time, String timeFromat, final String defaultValue) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(timeFromat);
            return dateFormat.format(time);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 格式化String时间
     *
     * @param time       String类型时间
     * @param timeFromat String类型格式
     * @return 格式化后的Date日期
     */
    public static Date parseStrToDate(String time, String timeFromat) {
        if (time == null || time.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(timeFromat);
            date = dateFormat.parse(time);
        } catch (Exception e) {

        }
        return date;
    }

    /**
     * 格式化String时间
     *
     * @param strTime      String类型时间
     * @param timeFromat   String类型格式
     * @param defaultValue 异常时返回的默认值
     * @return
     */
    public static Date parseStrToDate(String strTime, String timeFromat,
                                      Date defaultValue) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(timeFromat);
            return dateFormat.parse(strTime);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 当strTime为2008-9时返回为2008-9-1 00:00格式日期时间，无法转换返回null.
     *
     * @param strTime
     * @return
     */
    public static Date strToDate(String strTime) {
        if (strTime == null || strTime.trim().length() <= 0)
            return null;

        Date date = null;
        List<String> list = new ArrayList<String>(0);

        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS);
        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI);
        list.add(DATE_TIME_FORMAT_YYYYMMDD_HH_MI);
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISS);
        list.add(DATE_FORMAT_YYYY_MM_DD);
        //list.add(DATE_FORMAT_YY_MM_DD);
        list.add(DATE_FORMAT_YYYYMMDD);
        list.add(DATE_FORMAT_YYYY_MM);
        list.add(DATE_FORMAT_YYYYMM);
        list.add(DATE_FORMAT_YYYY);


        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            String format = (String) iter.next();
            if (strTime.indexOf("-") > 0 && format.indexOf("-") < 0)
                continue;
            if (strTime.indexOf("-") < 0 && format.indexOf("-") > 0)
                continue;
            if (strTime.length() > format.length())
                continue;
            date = parseStrToDate(strTime, format);
            if (date != null)
                break;
        }

        return date;
    }

    /**
     * 解析两个日期之间的所有月份
     *
     * @param beginDateStr 开始日期，至少精确到yyyy-MM
     * @param endDateStr   结束日期，至少精确到yyyy-MM
     * @return yyyy-MM日期集合
     */
    public static List<String> getMonthListOfDate(String beginDateStr, String endDateStr) {
        // 指定要解析的时间格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
        // 返回的月份列表
        String sRet = "";

        // 定义一些变量
        Date beginDate = null;
        Date endDate = null;

        GregorianCalendar beginGC = null;
        GregorianCalendar endGC = null;
        List<String> list = new ArrayList<String>();

        try {
            // 将字符串parse成日期
            beginDate = f.parse(beginDateStr);
            endDate = f.parse(endDateStr);

            // 设置日历
            beginGC = new GregorianCalendar();
            beginGC.setTime(beginDate);

            endGC = new GregorianCalendar();
            endGC.setTime(endDate);

            // 直到两个时间相同
            while (beginGC.getTime().compareTo(endGC.getTime()) <= 0) {
                sRet = beginGC.get(Calendar.YEAR) + "-"
                        + (beginGC.get(Calendar.MONTH) + 1);
                list.add(sRet);
                // 以月为单位，增加时间
                beginGC.add(Calendar.MONTH, 1);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解析两个日期段之间的所有日期
     *
     * @param beginDateStr 开始日期  ，至少精确到yyyy-MM-dd
     * @param endDateStr   结束日期  ，至少精确到yyyy-MM-dd
     * @return yyyy-MM-dd日期集合
     */
    public static List<String> getDayListOfDate(String beginDateStr, String endDateStr) {
        // 指定要解析的时间格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        // 定义一些变量
        Date beginDate = null;
        Date endDate = null;

        Calendar beginGC = null;
        Calendar endGC = null;
        List<String> list = new ArrayList<String>();

        try {
            // 将字符串parse成日期
            beginDate = f.parse(beginDateStr);
            endDate = f.parse(endDateStr);

            // 设置日历
            beginGC = Calendar.getInstance();
            beginGC.setTime(beginDate);

            endGC = Calendar.getInstance();
            endGC.setTime(endDate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // 直到两个时间相同
            while (beginGC.getTime().compareTo(endGC.getTime()) <= 0) {

                list.add(sdf.format(beginGC.getTime()));
                // 以日为单位，增加时间
                beginGC.add(Calendar.DAY_OF_MONTH, 1);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当下年份指定前后数量的年份集合
     *
     * @param before 当下年份前年数
     * @param behind 当下年份后年数
     * @return 集合
     */
    public static List<Integer> getYearListOfYears(int before, int behind) {
        if (before < 0 || behind < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        Calendar c = null;
        c = Calendar.getInstance();
        c.setTime(new Date());
        int currYear = Calendar.getInstance().get(Calendar.YEAR);

        int startYear = currYear - before;
        int endYear = currYear + behind;
        for (int i = startYear; i < endYear; i++) {
            list.add(Integer.valueOf(i));
        }
        return list;
    }

    /**
     * 获取当前日期是一年中第几周
     *
     * @param date
     * @return
     */
    public static Integer getWeekthOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);

        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取某一年各星期的始终时间
     * 实例：getWeekList(2016)，第52周(从2016-12-26至2017-01-01)
     *
     * @param year 年份
     * @return
     */
    public static HashMap<Integer, String> getWeekTimeOfYear(int year) {
        HashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        int count = getWeekthOfYear(c.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dayOfWeekStart = "";
        String dayOfWeekEnd = "";
        for (int i = 1; i <= count; i++) {
            dayOfWeekStart = sdf.format(getFirstDayOfWeek(year, i));
            dayOfWeekEnd = sdf.format(getLastDayOfWeek(year, i));
            map.put(Integer.valueOf(i), "第" + i + "周(从" + dayOfWeekStart + "至" + dayOfWeekEnd + ")");
        }
        return map;

    }

    /**
     * 获取某一年的总周数
     *
     * @param year
     * @return
     */
    public static Integer getWeekCountOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        int count = getWeekthOfYear(c.getTime());
        return count;
    }

    /**
     * 获取指定日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 获取指定日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    /**
     * 获取某年某周的第一天
     *
     * @param year 目标年份
     * @param week 目标周数
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 获取某年某周的最后一天
     *
     * @param year 目标年份
     * @param week 目标周数
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 获取某年某月的第一天
     *
     * @param year  目标年份
     * @param month 目标月份
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        month = month - 1;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);

        int day = c.getActualMinimum(c.DAY_OF_MONTH);

        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取某年某月的最后一天
     *
     * @param year  目标年份
     * @param month 目标月份
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {
        month = month - 1;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        int day = c.getActualMaximum(c.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 获取某个日期为星期几
     *
     * @param date
     * @return String "星期*"
     */
    public static String getDayWeekOfDate1(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

    /**
     * 获得指定日期的星期几数
     *
     * @param date
     * @return int
     */
    public static Integer getDayWeekOfDate2(Date date) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(date);
        int weekDay = aCalendar.get(Calendar.DAY_OF_WEEK);
        return weekDay;
    }

    /**
     * 验证字符串是否为日期
     * 验证格式:YYYYMMDD、YYYY_MM_DD、YYYYMMDDHHMISS、YYYYMMDD_HH_MI、YYYY_MM_DD_HH_MI、YYYYMMDDHHMISSSSS、YYYY_MM_DD_HH_MI_SS
     *
     * @param strTime
     * @return null时返回false;true为日期，false不为日期
     */
    public static boolean validateIsDate(String strTime) {
        if (strTime == null || strTime.trim().length() <= 0)
            return false;

        Date date = null;
        List<String> list = new ArrayList<String>(0);

        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS);
        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI);
        list.add(DATE_TIME_FORMAT_YYYYMMDD_HH_MI);
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISS);
        list.add(DATE_FORMAT_YYYY_MM_DD);
        //list.add(DATE_FORMAT_YY_MM_DD);
        list.add(DATE_FORMAT_YYYYMMDD);
        //list.add(DATE_FORMAT_YYYY_MM);
        //list.add(DATE_FORMAT_YYYYMM);
        //list.add(DATE_FORMAT_YYYY);

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            String format = (String) iter.next();
            if (strTime.indexOf("-") > 0 && format.indexOf("-") < 0)
                continue;
            if (strTime.indexOf("-") < 0 && format.indexOf("-") > 0)
                continue;
            if (strTime.length() > format.length())
                continue;
            date = parseStrToDate(strTime.trim(), format);
            if (date != null)
                break;
        }

        if (date != null) {
            System.out.println("生成的日期:" + DateUtil.parseDateToStr(date, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS, "--null--"));
            return true;
        }
        return false;
    }

    /**
     * 将指定日期的时分秒格式为零
     *
     * @param date
     * @return
     */
    public static Date formatHhMmSsOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得指定时间加减参数后的日期(不计算则输入0)
     *
     * @param date        指定日期
     * @param year        年数，可正可负
     * @param month       月数，可正可负
     * @param day         天数，可正可负
     * @param hour        小时数，可正可负
     * @param minute      分钟数，可正可负
     * @param second      秒数，可正可负
     * @param millisecond 毫秒数，可正可负
     * @return 计算后的日期
     */
    public static Date addDate(Date date, int year, int month, int day, int hour, int minute, int second, int millisecond) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, year);//加减年数
        c.add(Calendar.MONTH, month);//加减月数
        c.add(Calendar.DATE, day);//加减天数
        c.add(Calendar.HOUR, hour);//加减小时数
        c.add(Calendar.MINUTE, minute);//加减分钟数
        c.add(Calendar.SECOND, second);//加减秒
        c.add(Calendar.MILLISECOND, millisecond);//加减毫秒数

        return c.getTime();
    }

    /**
     * 获得两个日期的时间戳之差
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDistanceTimestamp(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return Long.valueOf(0);
        }
        long daysBetween = (endDate.getTime() - startDate.getTime() + 1000000) / (3600 * 24 * 1000);
        return daysBetween;
    }

    /**
     * 判断二个时间是否为同年同月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Boolean compareIsSameMonth(Date date1, Date date2) {
        boolean flag = false;
        int year1 = getYear(date1);
        int year2 = getYear(date2);
        if (year1 == year2) {
            int month1 = getMonth(date1);
            int month2 = getMonth(date2);
            if (month1 == month2) flag = true;
        }
        return flag;
    }

    /**
     * 获得两个时间相差距离多少天多少小时多少分多少秒
     *
     * @param one 时间参数 1 格式：1990-01-01 12:00:00
     * @param two 时间参数 2 格式：2009-01-01 12:00:00
     * @return long[] 返回值为：{天, 时, 分, 秒}
     */
    public static long[] getDistanceTime(Date one, Date two) {
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {

            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long[] times = {day, hour, min, sec};
        return times;
    }

    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     *
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return String 返回值为：{天, 时, 分, 秒}
     */
    public static long[] getDistanceTime(String str1, String str2) {
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long[] times = {day, hour, min, sec};
        return times;
    }

    /**
     * 两个时间之间相差距离多少天
     *
     * @param str1 时间参数 1：
     * @param str2 时间参数 2：
     * @return 相差天数
     */
    public static Long getDistanceDays(String str1, String str2) throws Exception {
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        Date one;
        Date two;
        long days = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 计算两个时间的小时差
     *
     * @param stime
     * @param otime
     * @return
     * @throws Exception
     */
    public static Long getTimeHoursDiff(String stime, String otime) {
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        Date one;
        Date two;
        long days = 0;
        try {
            one = df.parse(stime);
            two = df.parse(otime);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 获取当前时间
     * @param stime
     * @param otime
     * @return
     */
    public static Long getTimeHoursDiff(Date stime, Date otime) {
        long days = 0;
        long time1 = stime.getTime();
        long time2 = otime.getTime();
        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        days = diff / (1000 * 60 * 60);
        return days;
    }

    /**
     * 计算两个时间的小时差
     *
     * @param one
     * @param two
     * @return
     * @throws Exception
     */
    public static Long getDateHoursDiff(Date one, Date two) {
        long days = 0;
        long time1 = one.getTime();
        long time2 = two.getTime();
        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        days = diff / (1000 * 60 * 60);
        return days;
    }
    /**
     * 获取当前时间
     *
     * @return
     * @throws Exception
     */
    public static String getTimeCurrent() {
        try {
            DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM);
            return df.format(new Date());
        } catch (Exception ex) {
        }
        return "";
    }


    /**
     * 获取指定时间的那天 00:00:00.000 的时间
     * @param date
     * @return
     */
//    public static Date getDayBeginTime(final Date date) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.set(Calendar.HOUR_OF_DAY, 0);
//        c.set(Calendar.MINUTE, 0);
//        c.set(Calendar.SECOND, 0);
//        c.set(Calendar.MILLISECOND, 0);
//        return c.getTime();
//    }

    /**
     * 获取指定时间的那天 23:59:59.999 的时间
     *
     * @param date
     * @return
     */
    public static Date getDayEndTime(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 计算两个日期之间的日期差
     *
     * @param sDate 开始时间
     * @param eDate 结束时间
     * @return
     * @throws Exception
     */
    public static Integer DaysInterval(String sDate, String eDate) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("YYYY-MM-DD");
        try {
            long from = simpleFormat.parse(sDate).getTime();
            long to = simpleFormat.parse(eDate).getTime();
            int days = (int) ((to - from) / (1000 * 60 * 60 * 24));
            return days;
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * 计算两个日期之间的日期差 返回小时
     *
     * @param sDate 开始时间
     * @param eDate 结束时间
     * @return
     * @throws Exception
     */
    public static Double HoursInterval(String sDate, String eDate) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long from = simpleFormat.parse(sDate).getTime();
            long to = simpleFormat.parse(eDate).getTime();
            DecimalFormat df = new DecimalFormat("#.00");
            Double days = Double.valueOf((to - from) / (1000 * 60 * 60));
            return Double.valueOf(df.format(days / 24));
        } catch (Exception ex) {
            return 0.0;
        }
    }

    /**
     * 计算输入日期到当前时间日期差 返回天数
     *
     * @param sDate 开始时间
     * @return
     * @throws Exception
     */
    public static Integer DaysIntervalCurrent(String sDate) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long from = simpleFormat.parse(sDate).getTime();
            long to = new Date().getTime();
            int days = (int) ((to - from) / (1000 * 60 * 60 * 24));
            return days;
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * 获取当前日期的某天（前几天的）工作日日期，周六周天除外
     *
     * @param dateCount
     * @return
     */
    public static String getPreDate(int dateCount) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        for (int i = 1; i <= dateCount; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            String weekDate = new SimpleDateFormat("EEEE").format(calendar.getTime());
            if (weekDate.equals("星期六") || weekDate.equals("星期日")) {
                calendar.add(Calendar.DAY_OF_MONTH, weekDate.equals("星期六") ? -1 : -2);
            }
        }
        String date = format.format(calendar.getTime());
        return date;
    }

    public static int StandardCycle(String date, int cycleCount) {
        Calendar calendar = Calendar.getInstance();
        //        try{
        //            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:00").parse(date));
        //        }
        //        catch(Exception ex)
        //        {
        //
        //        }
        int days = 0;
        for (int i = 1; i <= cycleCount; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            String weekDate = new SimpleDateFormat("EEEE").format(calendar.getTime());
            if (!(weekDate.equals("星期六") || weekDate.equals("星期日"))) {
                days += 1;
            }
        }
        return days > 0 ? days : 1;
    }

    /**
     * 取得当月天数
     */
    public static int getCurrentMonthLastDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     *      * 获取两个日期相差的月数
     *      
     */
    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2 && day1 < day2)
            yearInterval--;
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2;
        if (day1 < day2)
            monthInterval--;
        monthInterval %= 12;
        int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
        return monthsDiff;
    }

    /**
      * <b>说明：</b>求出两个时间之间的所有工作日<br>
      * @param
      * @return
      * <b>修改履历：</b>
      * @author  2018/11/28 孙强
      */
    public static int calLeaveDays(Date startTime, Date endTime) {
        int leaveDays = 0;
        //从startTime开始循环，若该日期不是节假日或者不是周六日则请假天数+1
        Date flag = startTime;//设置循环开始日期
        Calendar cal = Calendar.getInstance();
        //循环遍历每个日期
        while (flag.compareTo(endTime) != 1) {
            cal.setTime(flag);
            //判断是否为周六日
            int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (week == 0 || week==6) {//0为周日，6为周六 (这里由于工作原因每周上6天,所以只判断week=0即可,如双休需要添加 || week==6)
                //跳出循环进入下一个日期
                cal.add(Calendar.DAY_OF_MONTH, +1);
                flag = cal.getTime();
                continue;
            }
            //不是节假日或者周末，天数+1
            leaveDays = leaveDays + 1;
            //日期往后加一天
            cal.add(Calendar.DAY_OF_MONTH, +1);
            flag = cal.getTime();
        }
        return leaveDays;
    }

    /**
     *   得到本月的第一天
     */

    public String getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat firstDay= new SimpleDateFormat("yyyy-MM-dd");
        return firstDay.format(calendar.getTime());
    }


    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            return day2-day1;
        }
    }

    /**
     * 获取任意时间的月的最后一天
     * 描述:<描述函数实现的功能>.
     * @param repeatDate
     * @return
     */
    public static String getMaxMonthDate(String repeatDate) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            if(StringUtils.isNotBlank(repeatDate) && !"null".equals(repeatDate)){
                calendar.setTime(dft.parse(repeatDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }


    /**
     * 获取任意时间的月第一天
     * 描述:<描述函数实现的功能>.
     * @param repeatDate
     * @return
     */
    public static String getMinMonthDate(String repeatDate){
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            if(StringUtils.isNotBlank(repeatDate) && !"null".equals(repeatDate)){
                calendar.setTime(dft.parse(repeatDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 获取上月第一天
     * 描述:<描述函数实现的功能>.
     * @param
     * @return
     */
    public static String getfirstMinMonthDate( ){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String  firstDay= null;
              //获取前月的第一天
              Calendar   cal_1=Calendar.getInstance();//获取当前日期
              cal_1.add(Calendar.MONTH, -1);
               cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
               firstDay = format.format(cal_1.getTime());
              return firstDay;
    }

    /**
     * 获取任意时间的月的最后一天
     * 描述:<描述函数实现的功能>.
     * @param
     * @return
     */
    public static String getLastMaxMonthDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String  firstDay= null;
        String  lastDay= null;
        //获取前月的第一天
        Calendar   cal_1=Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        firstDay = format.format(cal_1.getTime());
//        System.out.println("-----1------firstDay:"+firstDay);
        //获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天
        lastDay = format.format(cale.getTime());
//        System.out.println("-----2------lastDay:"+lastDay);
        return lastDay;
    }
    /**
     * <b>说明：</b>求出两个时间差(天数)<br>
     * @param
     * @return
     * <b>修改履历：</b>
     * @author  2018/11/28 孙强
     */
    public static long getDaysBetween(Date startDate, Date endDate) {
        // 86400000=3600*24*1000 用立即数，减少乘法计算的开销 　　
        long daysBetween = (endDate.getTime() - startDate.getTime() + 1000000) / 86400000;
        return daysBetween;
    }
    /**
     * <b>说明：</b>获取当前周第一天(天数)<br>
     * @param
     * @return
     * <b>修改履历：</b>
     * @author  2018/11/28 刘欢
     */
    public static String getFirstOfWeek(String dataStr)  {
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        String data1 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        String data2 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return data1;

    }
    /**
     * <b>说明：</b>获取当前周最后一天(天数)<br>
     * @param
     * @return
     * <b>修改履历：</b>
     * @author  2018/11/28 孙强
     */
    public static String getLastOfWeek(String dataStr)  {
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        String data2 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return data2;

    }


    /**
     * 获得该月第一天
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonthStr(int year,int month){
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }
    /**
     * java中如何判断两个日期是否是同一周
     * @author Administrator
     * java中的Calendar是比较强的。
     * “2004-12-25”是星期六，也就是说它是2004年中第52周的星期六，
     * 那么“2004-12-26”到底是2004年的第几周哪，java中经测试取得的它的Week值是1，
     * 那么也就是说它被看作2005年的第一周了，这个处理是比较好的。
     * 可以用来判断“2004-12-26”和“2005-1-1”是同一周。
     *
     * 姓名：刘欢
     */
        public static boolean isSameDate(String date1, String date2)
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = null;
            Date d2 = null;
            try
            {
                d1 = format.parse(date1);
                d2 = format.parse(date2);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setFirstDayOfWeek(Calendar.MONDAY);//西方周日为一周的第一天，咱得将周一设为一周第一天
            cal2.setFirstDayOfWeek(Calendar.MONDAY);
            cal1.setTime(d1);
            cal2.setTime(d2);
            int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
            if (subYear == 0)// subYear==0,说明是同一年
            {
                if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                    return true;
            }
            else if (subYear == 1 && cal2.get(Calendar.MONTH) == 11) //subYear==1,说明cal比cal2大一年;java的一月用"0"标识，那么12月用"11"
            {
                if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                    return true;
            }
            else if (subYear == -1 && cal1.get(Calendar.MONTH) == 11)//subYear==-1,说明cal比cal2小一年
            {
                if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                    return true;
            }
            return false;
        }
    /**
     * <b>说明：</b>上星期第一天(天数)<br>
     * @param
     * @return
     * <b>修改履历：</b>
     * @author  2018/11/28 孙强
     */
    public static String getMonday() {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        cal.add(Calendar.DATE, -1*7);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        String monday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return monday;
    }


    /**
     * 获得该月最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonthStr(int year,int month){
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }
    /**
     * 解析两个日期段之间的所有所在周的日期
     *
     * @param beginDateStr 开始日期  ，至少精确到yyyy-MM-dd
     * @param endDateStr   结束日期  ，至少精确到yyyy-MM-dd
     * @return yyyy-MM-dd日期集合
     */
    public static List<String> getWeekListOfDate(String beginDateStr, String endDateStr) {
        // 指定要解析的时间格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        // 定义一些变量
        Date beginDate = null;
        Date endDate = null;

        Calendar beginGC = null;
        Calendar endGC = null;
        List<String> list = new ArrayList<String>();

        try {
            // 将字符串parse成日期
            beginDate = f.parse(beginDateStr);
            endDate = f.parse(endDateStr);

            // 设置日历
            beginGC = Calendar.getInstance();
            beginGC.setTime(beginDate);

            endGC = Calendar.getInstance();
            endGC.setTime(endDate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // 直到两个时间相同
            while (beginGC.getTime().compareTo(endGC.getTime()) <= 0) {

                list.add(sdf.format(beginGC.getTime()));
                // 以日为单位，增加时间
                beginGC.add(Calendar.DAY_OF_MONTH, 7);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取本月第多少天  注意天数限制
     * @param i 前几个月时间
     * @return
     */
    public static Date getLastMonthDateByMonthInt(int i){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

    /**
     * 获取本月第多少天  注意天数限制
     * @param day
     * @return
     */
    public static Date getYearMonthByDay(int day){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),day);
        return cal.getTime();
    }



    /**
     * 判断时间格式 格式必须为“YYYY-MM-dd”
     * 2004-2-30 是无效的
     * 2003-2-29 是无效的
     * @param sDate
     * @return
     */
    public static boolean isLegalDate(String sDate) {
        int legalLen = 10;
        if ((sDate == null) || (sDate.length() != legalLen)) {
            return false;
        }

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(sDate);
            return sDate.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取指定月份的最后一天
     * @param yearMonth 日期字符串
     * @return
     */

    public static String getLastDayOfMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.split("-")[0]);  //年
        int month = Integer.parseInt(yearMonth.split("-")[1]); //月
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    public static void main(String[] args) {
        Date date = new Date();
        Integer day = DateUtil.getDay(date);
        System.out.println(day);
    }

}
