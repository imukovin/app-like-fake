import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
		    ZStack {
		        Color.black.ignoresSafeArea(.all) // status bar color
			    ContentView()
            }.preferredColorScheme(.light)
		}
	}
}
