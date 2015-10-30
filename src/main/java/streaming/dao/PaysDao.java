/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import org.springframework.data.repository.CrudRepository;
import streaming.entity.Pays;

/**
 *
 * @author ETY01
 */
public interface PaysDao extends CrudRepository<Pays, Long>{
    
}
