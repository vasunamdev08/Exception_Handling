package assignment.q7;

class ResourceA implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Exception from ResourceA.close()");
    }
}