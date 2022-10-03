#include "com_nulstudio_medicalcommunication_controller_TestController.h"
#include <string>

extern "C" JNIEXPORT jint JNICALL Java_com_nulstudio_medicalcommunication_controller_TestController_testJni
             (JNIEnv* env, jobject thiz, jint a, jint b) {
             return a + b;
}