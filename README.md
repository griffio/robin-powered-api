##Robin Powered Api with Retrofit, OkHttp, Gson and AutoValue

###Example with TypeAdapterFactory, TypeAdapters, Deserialisers

Robin api uses a "data" element enclosure to wrap resource responses - TypeAdapterFactory can be used to unwrap.

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
