package Util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LichLam_CaLam {

    public static List<Date> seven_Days(Date Ngay) {
        List<Date> list = new ArrayList<>(7);

        // Chuyển đổi Date sang LocalDate
        LocalDate specificDate = Ngay.toLocalDate();

        LocalDate thu2 = specificDate.with(DayOfWeek.MONDAY);

        for (int i = 0; i < 7; i++) {
            LocalDate currentDay = thu2.plusDays(i); // Ngày thứ Hai + i ngày
            Date day = Date.valueOf(currentDay);      // Chuyển LocalDate thành Date
            list.add(day);
        }

        return list;
    }

    public static List<String> getWeekHeaders(String dateStr) {
        // Chuyển đổi String thành LocalDate
        LocalDate specificDate = LocalDate.parse(dateStr); // Giả sử dateStr có định dạng yyyy-MM-dd

        // Lấy ngày thứ Hai trong tuần của specificDate
        LocalDate thu2 = specificDate.with(DayOfWeek.MONDAY);

        // Định dạng ngày theo "dd/MM"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

        // Danh sách để lưu tên cột
        List<String> headers = new ArrayList<>();
        headers.add("Nhân Viên");
        // Thêm tên các cột vào danh sách (T2, T3, T4, ...)
        for (int i = 0; i < 7; i++) {
            LocalDate currentDay = thu2.plusDays(i); // Thêm i ngày vào ngày thứ Hai
            String formattedDate = currentDay.format(formatter); // Định dạng ngày
            if (i != 6) {
                headers.add("T" + (i + 2) + " " + formattedDate); // Thêm vào danh sách, ví dụ: T2 25/11
            } else {
                headers.add("CN" + " " + formattedDate); // Thêm vào danh sách, ví dụ: T2 25/11
            }
        }

        return headers;
    }

    public static String thu2(Date Ngay) {
        // Chuyển đổi Date sang LocalDate
        LocalDate specificDate = Ngay.toLocalDate();
        LocalDate thu2 = specificDate.with(DayOfWeek.MONDAY);
        Date day = Date.valueOf(thu2);      // Chuyển LocalDate thành Date

        return day.toString();
    }

    public static List<Date> DauTuan_CuoiTuan(Date Ngay) {
        List<Date> list = new ArrayList<>(2);

        // Chuyển đổi Date sang LocalDate
        LocalDate specificDate = Ngay.toLocalDate();

        LocalDate startOfWeek = specificDate.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = startOfWeek.plusDays(6);

        Date dauTuan = Date.valueOf(startOfWeek);
        Date cuoiTuan = Date.valueOf(endOfWeek);

        list.add(dauTuan);
        list.add(cuoiTuan);

        return list;
    }

    public static String datechooser_cast_dangChuan(java.util.Date dateChooser) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(dateChooser);

        return formattedDate;
    }

    public static String yyyy_mm_dd__to__dd_mm_yyyy(String pre_ngay) {
        Date a = Date.valueOf(pre_ngay);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String ngay = dateFormat.format(a);

        return ngay;
    }

    public static String dd_mm_yyyy__to__yyyy_mm_dd(String pre_ngay) {
        String ngay = pre_ngay.substring(0, 2);
        String thang = pre_ngay.substring(3, 5);
        String nam = pre_ngay.substring(6, 10);

        String ngay_formatted = nam + "-" + thang + "-" + ngay;
        return ngay_formatted;
    }

    public static String chuyen_Date_sang_String(Date date) {
        // Định dạng chuỗi ngày giờ 'yyyy-MM-dd'
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Chuyển đổi Date sang String
        String string = sdf.format(date);
        return string;
    }

    public static String check_time_CaLam(String time) {
        String thongBao = "";

        if (time.length() != 5) {
            thongBao = thongBao + "- Sai độ dài chuỗi (cần đúng định dạng hh:mm) \n";
        } else {

            String hourStr = time.substring(0, 2);
            String colon = time.substring(2, 3);
            String minuteStr = time.substring(3, 5);

            if (!colon.equals(":")) {
                thongBao = thongBao + "- Sai dấu : \n";
            }

            try {
                int hour = Integer.parseInt(hourStr);
                if (hour < 0 || hour > 23) {
                    thongBao = thongBao + "- Giá trị giờ nhỏ hơn 24 \n";
                }
            } catch (NumberFormatException e) {
                thongBao = thongBao + "- Giờ không phải là số \n";
            }

            try {
                int minute = Integer.parseInt(minuteStr);
                if (minute < 0 || minute > 59) {
                    thongBao = thongBao + "- Giá trị phút nhỏ hơn 60 \n";
                }
            } catch (NumberFormatException e) {
                thongBao = thongBao + "- Phút không phải là số \n";
            }
        }
        return thongBao;
    }

    public static String time_sql_sang_hhmm(String timesql) {
        return timesql.substring(0, 5);
    }

    public static void main(String[] args) {
        System.out.println(time_sql_sang_hhmm("00:00:4544545454"));
    }
}
