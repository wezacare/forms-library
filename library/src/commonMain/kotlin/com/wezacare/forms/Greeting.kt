package com.wezacare.forms


class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}



//@Composable
//fun DemographicForm() {
//    var firstName by remember { mutableStateOf(TextFieldValue("")) }
//    var middleName by remember { mutableStateOf(TextFieldValue("")) }
//    var lastName by remember { mutableStateOf(TextFieldValue("")) }
//    var dob by remember { mutableStateOf(TextFieldValue("4/5/2024")) }
//    var reason by remember { mutableStateOf(TextFieldValue("")) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp),
//            shape = RoundedCornerShape(16.dp),
//            colors = CardDefaults.cardColors(
//                containerColor = Color.White
//            )
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = "Demographic Information",
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(bottom = 16.dp)
//                )
//
//                // First Name Field
//                FormField(
//                    label = "What is your first name?",
//                    value = firstName,
//                    onValueChange = { firstName = it }
//                )
//
//                // Middle Name Field
//                FormField(
//                    label = "What is your middle name?",
//                    value = middleName,
//                    onValueChange = { middleName = it }
//                )
//
//                // Last Name Field
//                FormField(
//                    label = "What is your last name",
//                    value = lastName,
//                    onValueChange = { lastName = it }
//                )
//
//                // Date of Birth Field
//                FormField(
//                    label = "What is your D.O.B.",
//                    value = dob,
//                    onValueChange = { dob = it }
//                )
//
//                // Reason Field
//                FormField(
//                    label = "What are the main reasons for seeking\nassistance from Majengo CCI today?",
//                    value = reason,
//                    onValueChange = { reason = it },
//                    height = 120.dp
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun FormField(
//    label: String,
//    value: TextFieldValue,
//    onValueChange: (TextFieldValue) -> Unit,
//    height: Dp = 80.dp
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(height)
//            .padding(vertical = 8.dp),
//        shape = RoundedCornerShape(16.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = Color(0xFFF9F9F9)
//        )
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 16.dp, vertical = 8.dp)
//        ) {
//            Text(
//                text = label,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Medium
//            )
//
//            TextField(
//                value = value,
//                onValueChange = onValueChange,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 4.dp),
//                placeholder = { Text("Your answer") },
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.Transparent,
//                    unfocusedContainerColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
//                )
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DemographicFormPreview() {
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = Color(0xFFE9E9E9)
//    ) {
//        DemographicForm()
//    }
//}