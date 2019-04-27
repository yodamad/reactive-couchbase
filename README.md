# Sample (not working) for spring boot with couchbase in reactive mode

See [Twiiter discussion](https://twitter.com/yodamad03/status/1121706008341045249) 

Inspired from [this article](https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux)

Couchbase info :
- Running locally (in a docker container) : `docker run -d --name couchbase_dev -p 8091-8094:8091-8094 -p 11210:11210 couchbase:community`
- Bucket : beer

Getting following on startup when trying to initialize data : `com.couchbase.client.java.error.ViewDoesNotExistException: View beer/all does not exist`