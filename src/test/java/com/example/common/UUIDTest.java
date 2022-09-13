package com.example.common;
import com.example.entity.Activatecode;
import com.example.mapper.Activate_informationMapper;
import com.example.mapper.ActivatecodeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UUIDTest {

    @Autowired
    private ActivatecodeMapper activatecodeMapper;


    @Test
    void testSaveBatch01(){
        List<Activatecode> ac = new ArrayList<>();

        for(int i = 900001; i < 1000001;i++){
            Activatecode activatecode = new Activatecode();
            activatecode.setId((long) i);
            activatecode.setActivationcode(UUIDStringUtils.randomUUID());
            ac.add(activatecode);
        }

        long start = System.currentTimeMillis();
        activatecodeMapper.insertBatch01(ac);
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start)+"毫秒");

    }




}
