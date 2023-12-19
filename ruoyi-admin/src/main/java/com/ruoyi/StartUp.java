package com.ruoyi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


/**
 * 服务启动执行，加载配置问题
 */
@Component
public class StartUp implements CommandLineRunner {

	private static final Log log = LogFactory.getLog(StartUp.class);

	@Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void run(String... args) {
        log.info("IndexStartupRunner >>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 <<<<<<<<<<<<<");
        //redis缓存持久化数据
        stringRedisTemplate.opsForValue().set("promotionURL","https://www.baidu.com/");
        log.info("IndexStartupRunner >>>>>>>>>>>>>>> redis缓存结束 <<<<<<<<<<<<<");
        System.out.println("(♥◠‿◠)ﾉﾞ  若依启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");

    }


}
