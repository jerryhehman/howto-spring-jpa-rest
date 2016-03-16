# Issues and Resolutions

| Issue | Resolution |
| ----- | ---------- |
| com.fasterxml.jackson.databind.JsonMappingException: Infinite recursion | The entity objects had the association properties included in the hashCode() method, which caused a recursive loop. The Collection properties for association elements should not be in the hashCode(), equals(), toString() methods |
| com.fasterxml.jackson.databind.JsonMappingException: No serializer found to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS | Added *com.fasterxml.jackson.datatype:jackson-datatype-hibernate4* as a dependency |