package com.mabuya.lindor.mobilehealthacre_android_services.repository;

import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Address;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.AddressRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.AddressRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by 213036223 on 4/24/2016.
 */
public class AddressRepositoryTest extends AndroidTestCase {
    private static final String TAG="ADDRESS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        AddressRepository repo = new AddressRepositoryImpl(this.getContext());

        // CREATE
        Address createEntity = new Address.Builder()
                .streetNumber(3)
                .streetName("Kotze")
                .town("Gardens")
                .city("Cape Town")
                .zipCode(8001)
                .build();
        Address insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Address> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        Address entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Address updateEntity = new Address.Builder()
                .copy(entity)
                .streetNumber(8)
                .build();
        repo.update(updateEntity);
        Address newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","TEST47",newEntity.getStreetNumber());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Address deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);


    }
}
