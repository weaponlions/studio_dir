#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_nativeApp_MainActivity_stringFromJNI( JNIEnv* env, jobject /* this */) {
    std::string hello = "Hello from C++ Harsh";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT void JNICALL
Java_com_example_nativeApp_MainActivity_startMain(JNIEnv *env, jobject thiz) {
    // TODO: implement startMain()
}