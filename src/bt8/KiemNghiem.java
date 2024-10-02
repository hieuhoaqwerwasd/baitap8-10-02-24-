package bt8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class KiemNghiem {
    
    public static void main(String[] args) {    
        DanhSachHangHoa dsHangHoa = new DanhSachHangHoa(10);
        
        dsHangHoa.themHangHoa(new HangSanhSu("HSS1", "Đĩa gốm", 20000, 60, "Bát Tràng", LocalDate.of(2024, 9, 15)));
        dsHangHoa.themHangHoa(new HangSanhSu("HSS2", "Bát gốm", 30000, 15, "Bát Tràng", LocalDate.of(2024, 9, 20)));
        dsHangHoa.themHangHoa(new HangSanhSu("HSS3", "Ly gốm", 25000, 20, "Bát Tràng", LocalDate.of(2024, 9, 20)));
        
        HangHoa[] temp = dsHangHoa.getDsHangHoa();
        for (HangHoa h : temp) {
            if (h != null) {
                System.out.println(h);
            }
        }
        
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.of(2024, 9, 15), LocalDate.now());
        System.out.println("Days since September 15, 2024: " + daysBetween);
    }
}
