package Util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;

public class BanHang {

    public static void main(String[] args) {
        System.out.println(set_Tien_VND(3000));
    }

    public static BufferedImage testLoadImage(String imagePath) {
        File imageFile = new File(imagePath);

        if (imageFile.exists() && imageFile.isFile()) {
            try {
                // Đọc và trả về ảnh
                return ImageIO.read(imageFile);
            } catch (IOException e) {
                System.out.println("Lỗi khi tải ảnh: " + imageFile.getName());
                e.printStackTrace();
            }
        } else {
            System.out.println("Ảnh không tồn tại hoặc không phải là tệp hợp lệ: " + imageFile.getPath());
        }

        return null; // Trả về null nếu không tải được ảnh
    }

    public static String set_Tien_VND(int gia) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        String gia_str = formatter.format(gia) + " VNĐ";
        return gia_str;
    }
}
