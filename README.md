##Robin Powered Api with Retrofit, OkHttp, Gson and AutoValue

updated for [Retrofit2 2.0.0-beta3](https://github.com/square/retrofit)

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
