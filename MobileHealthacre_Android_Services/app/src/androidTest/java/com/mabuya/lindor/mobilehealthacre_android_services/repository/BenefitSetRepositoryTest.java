package com.mabuya.lindor.mobilehealthacre_android_services.repository;

import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.BenefitSet;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.BenefitSetRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.BenefitSetRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by LILO on 2016/05/08.
 */
public class BenefitSetRepositoryTest extends AndroidTestCase {
    private static final String TAG = "BENEFIT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        BenefitSetRepository repo = new BenefitSetRepositoryImpl(this.getContext());
        //CREATE
        BenefitSet createEntity = new BenefitSet.Builder()
                .insuranceCoverage("Health")
                .benefit("Life and Disability")
                .benefitCost(250)
                .build();
        BenefitSet insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<BenefitSet> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        BenefitSet entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        BenefitSet updateEntity = new BenefitSet.Builder()
                .copy(entity)
                .benefit("Dread Diseases")
                .build();
        repo.update(updateEntity);
        BenefitSet newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Dread Diseases",newEntity.getBenefit());

        // DELETE ENTITY
        repo.delete(updateEntity);
        BenefitSet deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
