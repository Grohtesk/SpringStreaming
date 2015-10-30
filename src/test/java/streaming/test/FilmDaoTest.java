package streaming.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.dao.FilmDao;
import streaming.dao.LienDao;
import streaming.entity.Film;
import streaming.spring.SpringConfig;

/**
 *
 * @author ETY01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class FilmDaoTest {
    
    @Autowired
    private FilmDao filmDao;
    @Autowired
    private LienDao lienDao;
    
    public FilmDaoTest() {
    }
    
    @Before
    public void setUp() {
        filmDao.deleteAll();
        
        filmDao.save(new Film(1L, "Les dents de la Mer", "un requin mange des gens", 1990, 90));
        filmDao.save(new Film(2L, "Aliens", "un machin mange des gens", 1990, 90));
        
    }
    
    @Test
    public void test(){
        Assert.assertEquals("Aliens", filmDao.findOne(2L).getTitre());
    }
    
}
