package com.mabuya.lindor.mobilehealthacre_android_services.repository;

import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.DemographicInfo;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.DemographicInfoRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.DemographicInfoRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by 213036223 on 4/24/2016.
 */
public class DemographicInfoRepositoryTest extends AndroidTestCase {
    private static final String TAG = "DEMOGRAPHIC TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        DemographicInfoRepository repo = new DemographicInfoRepositoryImpl(this.getContext());

        //CREATE
        DemographicInfo createEntity = new DemographicInfo.Builder()
                .age(23)
                .sex("Female")
                .maritalStatus("Single")
                .occupation("Doctor")
                .salary(20000)
                .build();
        DemographicInfo insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " READ ENTITY", insertedEntity);

        //READ ALL
        Set<DemographicInfo> demographicInfos = repo.findAll();
        Assert.assertTrue(TAG + "READ ALL", demographicInfos.size() > 0);

        //READ ENTITY
        DemographicInfo entity = repo.findById(id);
        Assert.assertNotNull(TAG + "READ ENTITY", entity);

        //UPDATE ENTITY
        DemographicInfo updateEntity = new DemographicInfo.Builder()
                .copy(entity)
                .age(24)
                .build();
        repo.update(updateEntity);
        DemographicInfo newEntity = repo.findById(id);
        Assert.assertEquals(TAG + "UPDATE ENTITY", "23", newEntity.getAge());

        //DELETE ENTITY
        repo.delete(updateEntity);
        DemographicInfo deletedEntity = repo.findById(id);
        Assert.assertNotNull(TAG + "DELETE", deletedEntity);

    }
}
