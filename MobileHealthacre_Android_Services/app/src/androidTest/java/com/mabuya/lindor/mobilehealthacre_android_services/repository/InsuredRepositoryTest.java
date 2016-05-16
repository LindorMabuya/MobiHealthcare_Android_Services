package com.mabuya.lindor.mobilehealthacre_android_services.repository;


import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Insured;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.InsuredRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.InsuredRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by LILO on 2016/05/08.
 */
public class InsuredRepositoryTest extends AndroidTestCase {
    private static final String TAG="INSURED TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {
        InsuredRepository repo = new InsuredRepositoryImpl(this.getContext());

        // CREATE
        Insured createEntity = new Insured.Builder()
                .coveredByInsurance("Person")
                .organization("Old Mutual")
                .build();
        Insured insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Insured> settings = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", settings.size() > 0);

        //READ ENTITY
        Insured entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Insured updateEntity = new Insured.Builder()
                .copy(entity)
                .organization("Discovery")
                .build();
        repo.update(updateEntity);
        Insured newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Discovery", newEntity.getOrganization());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Insured deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }

    }
