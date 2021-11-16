import React from 'react'

export default function Navbar() {
    return (
        <div className="bg-blue-500">
            <div className="flex items-center justify-between">
                <div>
                    <a href="">
                        {process.env.appName}
                        
                    </a>
                </div>
                <div>
                    <a href>

                    </a>
                </div>
                <div>
                    <a href="/login">
                        Login
                    </a>
                </div>
                <div>
                    <a href="/register">
                        Register
                    </a>
                </div>
            </div>
        </div>
    )
}
