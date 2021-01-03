import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lieying.dao.ChatMapper;
import org.lieying.dao.JobHunterMapper;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        JobHunterMapper jobHunterMapper=sqlSession.getMapper(JobHunterMapper.class);
        System.out.println(jobHunterMapper.selectAllJobHunter());

    }
}
