## Robin Powered Api with Retrofit, OkHttp, Gson and AutoValue

updated for [Retrofit2 v2.1.0](https://github.com/square/retrofit)

### Example with TypeAdapterFactory, TypeAdapters, Deserialisers

Robin Powered api uses a "data" element enclosure to wrap resource responses - TypeAdapterFactory can be used to unwrap.

~~~json
{
  "data": [
    {}
  ],
   "meta": {},
   "paging": {
    "page": 1,
    "per_page": 10
   }
}
