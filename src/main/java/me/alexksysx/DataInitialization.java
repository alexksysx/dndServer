package me.alexksysx;

import me.alexksysx.model.Size;
import me.alexksysx.repo.SizeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DataInitialization {

    @Bean
    public boolean initSize(SizeRepository sizeRepository)
    {
        ArrayList<Size> sizeArrayList = new ArrayList<>();
        sizeArrayList.add(new Size(1L, "Tiny", "2 1/2 by 2 1/2 ft."));
        sizeArrayList.add(new Size(2L, "Small", "5 by 5 ft."));
        sizeArrayList.add(new Size(3L, "Medium", "5 by 5 ft."));
        sizeArrayList.add(new Size(4L, "Large", "10 by 10 ft."));
        sizeArrayList.add(new Size(5L, "Huge", "15 by 15 ft."));
        sizeArrayList.add(new Size(6L, "Gargantuan", "20 by 20 ft. or larger"));
        for(Size size: sizeArrayList) {
            if (!sizeRepository.existsSizeByNameAndSpace(size.getName(), size.getSpace()))
            {
                sizeRepository.save(size);
            }
        }
        return true;
    }

}
