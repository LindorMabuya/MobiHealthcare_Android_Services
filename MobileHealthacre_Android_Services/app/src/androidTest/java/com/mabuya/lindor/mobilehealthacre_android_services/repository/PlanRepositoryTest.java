package com.mabuya.lindor.mobilehealthacre_android_services.repository;

import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Plan;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.PlanRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.PlanRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by LILO on 2016/05/08.
 */
public class PlanRepositoryTest extends AndroidTestCase {
    private static final String TAG="PAYER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        PlanRepository repo = new PlanRepositoryImpl(this.getContext());

        // CREATE
        Plan createEntity = new Plan.Builder()
                .riskCover("Accidental Death")
                .fixedIncomeReturn(800000)
                .tax(14)
                .build();
        Plan insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Plan> settings = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", settings.size() > 0);

        //READ ENTITY
        Plan entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Plan updateEntity = new Plan.Builder()
                .copy(entity)
                .riskCover("Dread Diseases")
                .build();
        repo.update(updateEntity);
        Plan newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Dread Diseases", newEntity.getRiskCover());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Plan deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }
}
