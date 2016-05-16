package com.mabuya.lindor.mobilehealthacre_android_services.repository;

import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Payer;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.PayerRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.PayerRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by LILO on 2016/05/08.
 */
public class PayerRepositoryTest extends AndroidTestCase {
    private static final String TAG="PAYER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        PayerRepository repo = new PayerRepositoryImpl(this.getContext());

        // CREATE
        Payer createEntity = new Payer.Builder()
                .accNum("213036223")
                .accType("Savings")
                .bankname("FNB")
                .build();
        Payer insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Payer> settings = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", settings.size() > 0);

        //READ ENTITY
        Payer entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Payer updateEntity = new Payer.Builder()
                .copy(entity)
                .accType("Cheque")
                .build();
        repo.update(updateEntity);
        Payer newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Cheque", newEntity.getAccType());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Payer deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }
}
