package teste.aular.application;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

public class S3 {
    private final AmazonS3 s3;


    public S3() {
        this.s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.SA_EAST_1).build();
    }

    public S3ObjectInputStream downloadImage(String bucketName, String hotelSlug) {
        ListObjectsV2Result result = this.s3.listObjectsV2("auular-hotels", hotelSlug);
        Optional<S3ObjectSummary> object =  result.getObjectSummaries().stream().findFirst();

        if (object.isEmpty()) {
            throw new RuntimeException("No object found!");
        }

        GetObjectRequest request = new GetObjectRequest(bucketName, object.get().getKey());
        S3Object o = this.s3.getObject(request);
        S3ObjectInputStream s3is = o.getObjectContent();

        return s3is;
    }
}
