package com.mabuya.lindor.mobilehealthacre_android_services.repository;

import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Coverage;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.CoverageRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.CoverageRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by LILO on 2016/05/08.
 */
public class CoverageRepositoryTest extends AndroidTestCase {
    private static final String TAG="COVERAGE TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        CoverageRepository repo = new CoverageRepositoryImpl(this.getContext());
        // CREATE
        Coverage createEntity = new Coverage.Builder()
                .build();
        Coverage insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Coverage> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        Coverage entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Coverage updateEntity = new Coverage.Builder()
                .build();
        repo.update(updateEntity);
        Coverage newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","123456789L",newEntity.getId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Coverage deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
