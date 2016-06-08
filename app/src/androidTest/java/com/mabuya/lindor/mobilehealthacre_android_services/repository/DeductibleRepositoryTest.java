package com.mabuya.lindor.mobilehealthacre_android_services.repository;

import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Deductible;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.DeductibleRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.DeductibleRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by LILO on 2016/05/08.
 */
public class DeductibleRepositoryTest extends AndroidTestCase{
    private static final String TAG="DEDUCTIBLE TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        DeductibleRepository repo = new DeductibleRepositoryImpl(this.getContext());
        // CREATE
        Deductible createEntity = new Deductible.Builder()
                .build();
        Deductible insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Deductible> settings = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", settings.size() > 0);

        //READ ENTITY
        Deductible entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Deductible updateEntity = new Deductible.Builder()
                .build();
        repo.update(updateEntity);
        Deductible newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "123456789L", newEntity.getId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Deductible deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }
}
