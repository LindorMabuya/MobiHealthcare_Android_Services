package com.mabuya.lindor.mobilehealthacre_android_services.repository;

import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Service;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.ServiceRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.ServiceRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by LILO on 2016/05/08.
 */
public class ServiceRepositoryTest extends AndroidTestCase {
    private static final String TAG="PAYER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ServiceRepository repo = new ServiceRepositoryImpl(this.getContext());

        // CREATE
        Service createEntity = new Service.Builder()
              // .policy( policy)
                .build();
        Service insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Service> settings = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", settings.size() > 0);

        //READ ENTITY
        Service entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Service updateEntity = new Service.Builder()
               // .policy(policy)
                .build();
        repo.update(updateEntity);
        Service newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Cheque", newEntity.getPolicy());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Service deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }
}
