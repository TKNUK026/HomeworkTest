# AAR file / gitrepositorylib module usage.

Add the gitrepositorylib.aar file to libs folder of the application project.
Include below dependencies.

```groovy
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.aar'])
    ......
}
```

OR one more way is, implement gitrepositorylib module in dependencies.

```groovy
dependencies {
    implementation project(path: ':gitrepositorylib')
    ......
}
```

# build.gradle dependencies.

```groovy
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.aar'])

    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    // Gson
    implementation 'com.google.code.gson:gson:2.8.6'
    // Retrifit
    implementation 'com.squareup.retrofit2:retrofit:2.6.2'
    implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
    // OKHttp
    implementation 'com.squareup.okhttp3:logging-interceptor:4.2.2'
    implementation 'com.squareup.okhttp3:okhttp:4.2.2'
}
```

# Usage
- To get the GitHub repository information "items" list in that item object contains name, privacy status, description and language info.
- Need to call GithubRepositorySDK.getRepositoryInfo(platform, organization) by passing Two parameters.
> - First parameter represents the platform inf e.g. android, ios, etc...
> - Second parameter represents the platform inf e.g. orgA, orgB, etc...
 
