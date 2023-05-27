package teste.aular.application;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.net.URL;
import java.time.Instant;
import java.util.Optional;
import java.util.stream.Stream;

public class S3 {
    private final AmazonS3 s3;


    public S3() {
        this.s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
    }

    public URL getTempUrl(String bucketName, String hotelSlug) {
        String prefix = hotelSlug + "/";
        ListObjectsV2Result result = this.s3.listObjectsV2(new ListObjectsV2Request().withBucketName("auular-hotel").withPrefix(prefix).withDelimiter("/"));

        Stream<S3ObjectSummary> object = result.getObjectSummaries().stream().filter((S3ObjectSummary o) -> !o.getKey().equals(prefix));

        Optional<S3ObjectSummary> objectFiltered = object.findFirst();

        if (objectFiltered.isEmpty()) {
            return null;
        }

        System.out.println(objectFiltered.get().getKey());

        java.util.Date expiration = new java.util.Date();
        long expTimeMillis = Instant.now().toEpochMilli();
        expTimeMillis += 1000 * 60 * 60;
        expiration.setTime(expTimeMillis);

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectFiltered.get().getKey()).withMethod(HttpMethod.GET).withExpiration(expiration);

        return this.s3.generatePresignedUrl(generatePresignedUrlRequest);
    }
}
